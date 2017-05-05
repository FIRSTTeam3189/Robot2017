package org.usfirst.frc.team3189.robot;

public class Constants {

	public static final double VISION_OFFSET = 1.0;
	public static final int VISION_PICTURE_WIDTH = 640;

	public static final double AUTO_FORWARD_SPEED = 0.35;
	public static final double AUTO_REVERSE_SPEED = 0.4;

	public static final double GYRO_SPEED_MULTIPLIER = .50;

	public static final double tuneP = 0.01;
	public static final double tuneI = 0.001;
	public static final double tuneD = 0.01;

	public static final double AUTO_ANGLE_OFF = 10;

	public static final double AUTO_STOP_DISTANCE = 12;
	public static final double AUTO_STOP_LEFT = 15; // same as first
	public static final double AUTO_STOP_RIGHT = 15; // same as second
	public static final double AUTO_DRIVE_SPEED = 0.35; // needs testing and
														// stuff as well

	public static final double AUTO_VISION_SPEED = 0.35;
	public static final double AUTO_VISION_RANGE = 10;

	public final static double HFC = 0.90;
	public final static double LFC = 0.98;
	public final static double SPEED_DIV = 46; // I don't know what this is

	public final static double INCHES_PER_ROTATION = 6;
	public final static int ENCODER_ACCURACY = 4;
	public final static double LOW_GEARING_RATIO = 2.16;
	public final static double HIGH_GEARING_RATIO = 3.68;

	public static final double CLAW_LOWER_SPEED = -0.5;
	public static final double CLAW_RAISE_SPEED = 0.5;
	public static final double CLIMB_SPEED = 0.85;

	public static final double ENCODER_TICKS_PER_INCH = 160;

	public static final double POTENTIOMETER_TOP = 250;
	public static final double POTENTIOMETER_MIDDLE = 280;
	public static final double POTENTIOMETER_BOTTOM = 375;
	public static final double CLAW_DOWN_SPEED = 0.3;
	public static final double CLAW_UP_SPEED = 0.4;
	public static final double DROPPER_OPEN_DELAY = 0.25;
	public static final double CLAW_POT_RANGE = 10;
}