package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The sight for the Robot
 *
 *@author Devlyn, Alex
 */
public class Vision extends Subsystem {

	public enum XY {
		x, y
	}
	// box_[box number]_[point number]_[x or y]

	NetworkTable table;

	public Vision() {
		table = NetworkTable.getTable("vision");

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
			for (int j = 0; i < 4; i++) {
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
