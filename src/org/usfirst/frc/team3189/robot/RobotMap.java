package org.usfirst.frc.team3189.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public final static int leftBack = 0;
	public final static int leftMiddle = 1;
	public final static int leftFront = 2;
	public final static int rightBack = 3;
	public final static int rightMiddle = 4;
	public final static int rightFront = 5;
	public final static int clawLiftingMotor = 6;

	public final static int dropperExtend = 0;
	public final static int dropperRetract = 1;
	public final static int gearboxLeftExtend = 2;
	public final static int gearboxLeftRetract = 3;
	public final static int gearboxRightExtend = 4;
	public final static int gearboxRightRetract = 5;
	public final static int grabberExtend = 6;
	public final static int grabberRetract = 7;
	public final static int lifterExtend = 8;
	public final static int lifterRetract = 9;
}
