/**
 * Provides an interface to use the gearbox of the {@link Drivetrain} for the
 * 2017 team 3189 robot
 */
package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	Piston pistonLeft = new Piston(RobotMap.GEARBOX_LEFT_EXTEND, RobotMap.GEARBOX_LEFT_RETRACT);
	Piston pistonRight = new Piston(RobotMap.GEARBOX_RIGHT_EXTEND, RobotMap.GEARBOX_RIGHT_RETRACT);

	/**
	 * Shifts up gearbox
	 */
	public void shiftUp() {

		pistonLeft.retract();
		pistonRight.retract();
	}

	/**
	 * Shifts down gearbox
	 */
	public void shiftDown() {

		pistonLeft.extend();
		pistonRight.extend();
	}

	/**
	 * Toggles the state of the pistons
	 */
	public void toggle() {

		pistonLeft.toggle();
		pistonRight.toggle();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
