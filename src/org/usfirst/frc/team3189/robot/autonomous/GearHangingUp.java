package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This opens the dropper for one second, then it closes it
 * 
 * @author Damon Wagenknecht and Nate Mansfield
 *
 */
public class GearHangingUp extends Command {
	public GearHangingUp() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	/**
	 * Opens Dropper and starts the timer for 1 second
	 */
	protected void initialize() {
		Robot.dropper.OpenDropper();
		setTimeout(1);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	/**
	 * Returns Timeout
	 */
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	/**
	 * Closes the Dropper
	 */
	protected void end() {
		Robot.dropper.CloseDropper();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	/**
	 * Closes the Dropper
	 */
	protected void interrupted() {
		Robot.dropper.CloseDropper();
	}
}
