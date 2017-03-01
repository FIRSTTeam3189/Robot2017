package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the robot forward with Sonar
 */
public class AutoDrivetrainSonarGoto extends Command {

	/**
	 * Stop's once value is reached
	 */
	double stopDistance;

	/**
	 * sets the stop distance for the robot
	 * 
	 * @param stopDistance
	 *            is the stop distance
	 */
	public AutoDrivetrainSonarGoto(double stopDistance) {
		requires(Robot.drivetrain);
		this.stopDistance = stopDistance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.tankDrive(-Constants.AUTO_FORWARD_SPEED, -Constants.AUTO_FORWARD_SPEED);
		// TODO make this command go backward if its too close
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (stopDistance + 1 >= Robot.drivetrain.sonarPing());
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
