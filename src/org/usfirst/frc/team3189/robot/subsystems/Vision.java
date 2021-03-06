package org.usfirst.frc.team3189.robot.subsystems;

import java.awt.List;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The sight for the Robot
 *
 * @author Devlyn, Alex
 */
public class Vision extends Subsystem implements Runnable {

	public enum XY {
		x, y
	}
	// box_[box number]_[point number]_[x or y]

	NetworkTable table;
	public double lastLoop = 0;
	
	public String hasInfo = "has_info";
	
	private SerialPort uart;
	private int address = 0xE2;
	private boolean running = true;
	private long lastUpdated = System.currentTimeMillis();  
	private boolean gotTarget = false;
	private int pixelsOff = 0;
	private int buad = 115200;
	private ArrayList<Byte> incoming = new ArrayList<Byte>();
	private int index;

	public Vision() {
		table = NetworkTable.getTable("vision");

	}
	
	public void start(){
		uart = new SerialPort(buad, Port.kMXP);
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		while(running){
			byte[] raw = serialRead();
			byte[] temp = raw;
			
			for(byte taco : raw){
				System.out.printf("%02X", taco);
			}
			
			int si = 0;
			
			while(si < temp.length){
				//SmartDashboard.put("VisionRaw", raw);
				if((index < 3 && temp[si] != 0x77) || index > 8)
					incoming.clear();
				else{
					incoming.add(new Byte(temp[si]));
				}
				
				if(index >= 7){
					lastUpdated = System.currentTimeMillis();
					System.out.println("LastUpdated: " + lastUpdated);
					SmartDashboard.putString("VisionLastUpdate", ""+lastUpdated);
					
					gotTarget = incoming.get(3) == 0x00 ? false : true;
					SmartDashboard.putBoolean("VisionGotTarget", gotTarget);
					byte[] bytes = new byte[4];
					
					for(int i = 4; i < 8; ++i)
						bytes[i - 4] = incoming.get(i);

					pixelsOff = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
					System.out.println("PixelsOff: " + pixelsOff);
					SmartDashboard.putString("PixelsOff", ""+pixelsOff);
					incoming.clear();
					index = 0;
				}else
					index = incoming.size();
				
				si++;
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public double getLoops(){
		return table.getNumber("loop_amount", -1);
	}
	
	public boolean IsHasInfo(){
		return table.getBoolean(hasInfo, false);
	}
	
	public boolean isGood(){
		boolean flag = getLoops() > lastLoop;
		lastLoop = getLoops();
		return flag && IsHasInfo();
	}
	
	public boolean getTarget(){
		return gotTarget;
	}
	
	public boolean hasUpdated(){
		return gotTarget && lastUpdated + 150 >= System.currentTimeMillis();
	}
	
	public void serialCheck(){
		if(uart == null){
			//uart = new SerialPort(buad, Port.kMXP);
		}
	}
	
	public int serialWrite(String data){
		serialCheck();
		return uart.writeString(data);
	}
	
	public byte[] serialRead(){
		serialCheck();
		return uart.read(8);
	}
	
	public int getPixelsOff(){
		return pixelsOff;
	}

	/**
	 * returns a single axis of a point of a box from the network tables.
	 * 
	 * @param boxNumber
	 *            which box to get the point from
	 * @param pointNumber
	 *            the number of the point to get
	 * @param xory
	 *            Get the X or the Y of the point
	 * @return the axis of the point from the box desired
	 */
	public double getPoint(int boxNumber, int pointNumber, XY xory) {
		return table.getNumber("box_" + boxNumber + "_" + pointNumber + "_" + (xory == XY.x ? 'x' : 'y'), -1);
	}

	/**
	 * gives you a value from the vision to use for knowing the center of the
	 * two rectangles.
	 * 
	 * @return distance base of peg from center of the screen (positive is right
	 *         of center, negative is left).
	 */
	public double getPegBase() {
		double[][][] points = new double[2][4][2];
		int validBoxs = 2;

		// get all of the boxes and points
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				points[i][j][0] = getPoint(i, j, XY.x);
				points[i][j][1] = getPoint(i, j, XY.y);
				if (points[i][j][0] < 0 && points[i][j][1] < 0) {
					validBoxs--;
					break;
				}
			}
		}

		// check how many boxes we have
		if (validBoxs == 2) {
			// get the id for the left most box
			int leftID = (points[0][0][0] < points[1][0][0] ? 0 : 1);

			// sort the boxes points based on how big the X value of the point
			// is. big to small
			points[0] = sortBox(points[0]);
			points[1] = sortBox(points[1]);

			// average the inner sides of both boxes
			int left = (int) ((points[leftID == 0 ? 0 : 1][0][0] + points[leftID == 0 ? 0 : 1][1][0]) / 2);
			int right = (int) ((points[leftID == 0 ? 1 : 0][3][0] + points[leftID == 0 ? 1 : 0][2][0]) / 2);

			// average left and right points to find the base of the peg.
			return (((left + right) / 2) - (Constants.VISION_PICTURE_WIDTH / 2));
		} else if (validBoxs == 1) {
			int count = 0;
			// add all of the Xs of the points together.
			for (int i = 0; i < 4; i++) {
				count += points[0][i][0];
			}
			// return the center box by averaging all the Xs
			return (count / 4.0d);
		}
		return 0;
	}

	/**
	 * sorts the points of a box biggest X first smallest X last
	 * 
	 * @param box
	 *            double[Points (must have 4 elements)][X and Y (must have 2
	 *            elements the X of the point being first)]
	 * @return double[][] the boxs points sorted by biggest X values. biggest to
	 *         smallest.
	 */
	public double[][] sortBox(double[][] box) {
		double[] key;
		int j;
		for (int i = 0; i < box.length; i++) {

			key = box[i];
			for (j = i - 1; (j >= 0) && (box[j][0] < key[0]); j--) {
				box[j + 1] = box[j];
			}
			box[j + 1] = key;
		}
		return box;
	}

	public void initDefaultCommand() {
	}

}
