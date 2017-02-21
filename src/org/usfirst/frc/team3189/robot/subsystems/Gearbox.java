/**
 * Provides an interface to use the gearbox of the {@link Drivetrain} for the
 * 2017 team 3189 robot
 */
package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.commands.GearboxLow;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	Piston piston = new Piston(RobotMap.GEARBOX_LOW, RobotMap.GEARBOX_HIGH);

	/**
	 * Shifts gearbox into High gear.
	 */
	public void shiftIntoHigh() {
		piston.extend();
	}

	/**
	 * Shifts gearbox into Low gear
	 */
	public void shiftIntoLow() {
		piston.retract();
	}

	/**
	 * Toggles the state of the gearboxs' pistons
	 */
	public void toggle() {
		piston.toggle();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new GearboxLow());
	}
}
