package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the robot forward with Sonar
 */
public class DriveForwardSonar extends Command {
	
	
	/**
	 * Stop's once value is reached 
	 */
	double stopDistance;

	/**
	 * sets the stop distance for the robot
	 * @param stopDistance is the stop distance
	 */
	
	public DriveForwardSonar(double stopDistance) {
	
		requires(Robot.drivetrain);
		this.stopDistance = stopDistance;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	/**
	 * Sets the speed of the Bot
	 */
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.tankDrive(-Constants.AUTO_FORWARD_SPEED,-Constants.AUTO_FORWARD_SPEED);
	}

	/**
	 * Returns true when the Bot is in range
	 */
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (stopDistance >= Robot.drivetrain.SonarPing());
	}

	/**
	 * Stops the robot if True
	 */
	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}
/**
 * Stops the Robot
 */
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}
}
