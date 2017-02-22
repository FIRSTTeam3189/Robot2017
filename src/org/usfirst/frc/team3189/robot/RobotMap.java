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

	public final static int DROPPER_OPEN = 3;
	public final static int DROPPER_CLOSED = 2;
	public final static int GEARBOX_LOW = 0;
	public final static int GEARBOX_HIGH = 1;
	public final static int CLAW_OPEN = 4;
	public final static int CLAW_CLOSED = 5;
	public final static int CLAW_EXTENDER_EXTEND = 6;
	public final static int CLAW_EXTENDER_RETRACT = 7;

	// public static final int ACCELEREMETER_PORT = 0;
	public static final int GYROSCOPE_PORT = 1;
	public static final int ULTRASONIC_PORT = 0;
	
	public static final int UPPER_LIMIT_SWITCH = 0;
	public static final int LOWER_LIMIT_SWITCH = 1;

}
