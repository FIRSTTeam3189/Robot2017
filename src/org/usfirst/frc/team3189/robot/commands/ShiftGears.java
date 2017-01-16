package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Nate Mansfield
 */
public class ShiftGears extends Command {
	/**
	 * Uses the gearbox subsystem
	 */
	public ShiftGears() {
		requires(Robot.gearbox);
	}

	/**
	 * calls the toggle method and toggles the gears.
	 */
	protected void initialize() {
		Robot.gearbox.toggle();

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
