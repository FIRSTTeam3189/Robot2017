package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Uses the gearbox subsystem
 *
 * @author Nate Mansfield
 */
public class GearboxLow extends Command {

	public GearboxLow() {
		requires(Robot.gearbox);
	}

	protected void initialize() {
		Robot.gearbox.shiftIntoLow();
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
