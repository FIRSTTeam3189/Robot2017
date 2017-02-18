/**
 * Provides an interface to use the gearbox of the {@link Drivetrain} for the
 * 2017 team 3189 robot
 */
package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.commands.ShiftDown;
import org.usfirst.frc.team3189.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	Piston piston = new Piston(RobotMap.GEARBOX_EXTEND, RobotMap.GEARBOX_RETRACT);

	/**
	 * Shifts up gearbox
	 */
	public void shiftUp() {

		piston.extend();
	}

	/**
	 * Shifts down gearbox
	 */
	public void shiftDown() {

		piston.retract();
	}

	/**
	 * Toggles the state of the pistons
	 */
	public void toggle() {
		piston.toggle();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ShiftDown());
	}
}
