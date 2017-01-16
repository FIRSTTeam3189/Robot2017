package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Nate Mansfield
 */
public class ShiftUp extends Command {
	/**
	 * Uses the gearbox subsystem
	 */
	public ShiftUp() {
		requires(Robot.gearbox);
	}

	/**
	 * calls the shift up method once and shifts the gears up
	 */
	protected void initialize() {
		Robot.gearbox.shiftUp();
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
