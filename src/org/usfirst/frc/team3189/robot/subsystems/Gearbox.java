package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Provides an interface to use the gearbox of the {@link Drivetrain} for the
 * 2017 team 3189 robot
 */
public class Gearbox extends Subsystem {
	Piston pistonLeft = new Piston(2, 0);
	Piston pistonRight = new Piston(3, 1);
	public void shiftUp() {
		/**
		 * Shifts up gearbox
		 */
		pistonLeft.retract();
		pistonRight.retract();
	}

	public void shiftDown() {
		/**
		 * Shifts down gearbox
		 */
		pistonLeft.extend();
		pistonRight.extend();
	}

	public void toggle() {
		/**
		 * Toggles the state of the pistons
		 */
		pistonLeft.toggle();
		pistonRight.toggle();
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
