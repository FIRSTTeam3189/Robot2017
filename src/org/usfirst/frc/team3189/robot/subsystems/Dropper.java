package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.commands.DropperClose;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Dropper extends Subsystem {

	private Piston piston;

	public Dropper() {
		piston = new Piston(RobotMap.DROPPER_OPEN, RobotMap.DROPPER_CLOSED);
	}

	// TODO java doc this
	public void open() {
		piston.extend();
	}

	// TODO java doc this
	public void close() {
		if (Robot.claw.isClawLow() || Robot.claw.isClawHigh()) {
			piston.retract();
		}
	}

	// TODO java doc this
	public void toggle() {
		if (piston.isRetracted() || Robot.claw.isClawLow() || Robot.claw.isClawHigh()) {
			piston.toggle();
		}

	}

	public void initDefaultCommand() {
		// setDefaultCommand(new DropperClose());
	}
}
