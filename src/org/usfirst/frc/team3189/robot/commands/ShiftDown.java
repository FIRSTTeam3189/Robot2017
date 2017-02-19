package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Uses the gearbox subsystem
 *
 * @author Nate Mansfield
 */
public class ShiftDown extends Command {

	public ShiftDown() {
		requires(Robot.gearbox);
	}
	/**
	 * calls the shiftDown method and shifts the gears down
	 */
	protected void initialize() {
		Robot.gearbox.shiftDown();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
