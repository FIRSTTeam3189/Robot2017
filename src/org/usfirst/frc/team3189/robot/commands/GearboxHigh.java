package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Nate Mansfield
 */
public class GearboxHigh extends Command {

	public GearboxHigh() {
		requires(Robot.gearbox);
	}

	protected void initialize() {
		Robot.gearbox.shiftIntoHigh();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
