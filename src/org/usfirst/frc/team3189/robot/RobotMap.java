package org.usfirst.frc.team3189.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public final static int LEFT_BACK = 0;
	public final static int LEFT_MIDDLE = 1;
	public final static int LEFT_FRONT = 2;
	public final static int RIGHT_BACK = 3;
	public final static int RIGHT_MIDDLE = 4;
	public final static int RIGHT_FRONT = 5;
	public final static int CLAW_LIFTING_MOTOR = 6;
	public final static int WINCH_MOTOR_1 = 7;
	public final static int WINCH_MOTOR_2 = 7;

	public final static int DROPPER_EXTEND = 0;
	public final static int DROPPER_RETRACT = 1;
	public final static int GEARBOX_EXTEND = 2;
	public final static int GEARBOX_RETRACT = 3;
	public final static int GEARBOX_RIGHT_EXTEND = 4;
	public final static int GEARBOX_RIGHT_RETRACT = 5;
	public final static int GRABBER_EXTEND = 6;
	public final static int GRABBER_RETRACT = 7;
	public final static int LIFTER_EXTEND = 8;
	public final static int LIFTER_RETRACT = 9;

	public final static double HFC = 0.90;
	public final static double LFC = 0.98;
	public final static double SPEED_DIV = 46; // I don't know what this is
	
	public static final int ACCELEREMETER_PORT = 0;
	public static final int GYROSCOPE_PORT = 0;
}
