package org.usfirst.frc.team3189.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public final static int LEFT_BACK = 1;
	public final static int LEFT_MIDDLE = 2;
	public final static int LEFT_FRONT = 3;
	public final static int RIGHT_BACK = 4;
	public final static int RIGHT_MIDDLE = 5;
	public final static int RIGHT_FRONT = 6;
	public final static int CLAW_LIFTING_MOTOR = 1;
	public final static int WINCH_MOTOR_1 = 0;

	public final static int DROPPER_EXTEND = 4;
	public final static int DROPPER_RETRACT = 5;
	public final static int GEARBOX_EXTEND = 0;
	public final static int GEARBOX_RETRACT = 1;
	public final static int GRABBER_EXTEND = 3;
	public final static int GRABBER_RETRACT = 2;
	public final static int LIFTER_EXTEND = 6;
	public final static int LIFTER_RETRACT = 7;

	public final static double HFC = 0.90;
	public final static double LFC = 0.98;
	public final static double SPEED_DIV = 46; // I don't know what this is
	
	public static final int ACCELEREMETER_PORT = 0;
	public static final int GYROSCOPE_PORT = 1;
	public static final int ULTRASONIC_PORT = 2;
	
	public static final double AUTO_STOP_DISTANCE = 12; //needs to be tested and calibrated and stuff. 12 is a random number.
	public static final double AUTO_STOP_LEFT = 15; //same as first
	public static final double AUTO_STOP_RIGHT = 15; //same as second
	public static final double AUTO_DRIVE_SPEED = 0.8;  //needs testing and stuff as well
}
