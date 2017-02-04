package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Trent, Nate
 */
public class Winch extends Subsystem {
	private Spark winchMotor1 = new Spark(RobotMap.WINCH_MOTOR_1);
	private Spark winchMotor2 = new Spark(RobotMap.WINCH_MOTOR_2);

	/**
	 * sets the speed for the winch
	 * 
	 * @param speed
	 *            value between 1 and -1 used to control the winch
	 */
	public void setWinchspeed(double speed) {
		winchMotor1.set(speed);
		winchMotor2.set(speed);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
