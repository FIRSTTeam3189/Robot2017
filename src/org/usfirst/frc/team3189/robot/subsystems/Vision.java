
package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Prvides vision for the robot
 * @author Alex, Dev, Nicky
 */
public class Vision extends Subsystem {

	public enum XY{
		x,y
	}
	//   box_[box number]_[point number]_[x or y]
	
	NetworkTable table;
	/**
	 * Get network table for vision
	 */
	public Vision() {
		table = NetworkTable.getTable("vision");
		
	}
	
	/**
	 * Get the points inside the boxes
	 * 
	 * @param boxNumber the number of boxes
	 * @param pointNumber return the points inside of the boxes
	 * @param xory wheather it is x or y
	 * @return the points
	 */
	public double getPoint(int boxNumber, int pointNumber, XY xory) {
		return table.getNumber("box_" + boxNumber + "_" + pointNumber + "_" + (xory == XY.x ? 'x' : 'y'), -1);
	}
	
	/**
	 * Get the midpoints of the boxes
	 * @return the midpoint
	 */
	public double getheThing(){
		double[][][] points = new double[2][4][2];
		int validBoxs = 2;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; i < 4; i++) {
				points[i][j][0] = getPoint(i, j, XY.x);
				points[i][j][1] = getPoint(i, j, XY.y);
				if(points[i][j][0] < 0 && points[i][j][1] < 0){
					validBoxs--;
					break;
				}
			}
		}
		if(validBoxs == 2){
			int leftID = (points[0][0][0] < points[1][0][0] ? 0 : 1);
			
			points[0] = sortBox(points[0]);
			points[1] = sortBox(points[1]);
			
			int left = (int) ((points[leftID == 0 ? 0 : 1][0][0] + points[leftID == 0 ? 0 : 1][1][0])/2);
			int right = (int) ((points[leftID == 0 ? 1 : 0][3][0] + points[leftID == 0 ? 1 : 0][2][0])/2);
			
			
			double distance = right - left;
			
			//TODO: Fix magic numbers.
			return ((distance * Constants.VISION_OFFSET)+((left + right)/2)-320);
		}else if(validBoxs == 1){
			int count = 0;
			for(int i = 0; i < 4; i++) {
				count += points[0][i][0];
			}
			return (count / 4.0d);
		}
		return 0;
	}
	
	public double[][] sortBox(double[][] box) {
		double[] key;
		int j;
		for(int i = 0; i < box.length; i++) {
			
			key = box[i];
			for(j = i - 1; (j >= 0) && (box[j][0] < key[0]); j--){
				box[j+1] = box[j];
			}
			box[j + 1] = key;
		}
		return box;
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

//Hey Gayboy
