package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Opens the dropper
 * 
 * @author Alex Rodgers
 */
public class DropperOpen extends Command {

	public DropperOpen() {
		requires(Robot.dropper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.dropper.open();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
