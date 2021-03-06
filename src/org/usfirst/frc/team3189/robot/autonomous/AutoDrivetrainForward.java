package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the robot forward
 * 
 * @author Alex Rodgers
 *
 */
public class AutoDrivetrainForward extends Command {

	/**
	 * The amount of time the robot will run
	 */
	private double time;

	/**
	 * Set how long the robot will be going forward.
	 * 
	 * @param time
	 *            how long the robots motors will be running
	 */
	public AutoDrivetrainForward(double time) {
		requires(Robot.drivetrain);
		this.time = time;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(time);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.tankDrive(-Constants.AUTO_FORWARD_SPEED, -Constants.AUTO_FORWARD_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}
}
