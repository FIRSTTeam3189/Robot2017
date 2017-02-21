package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns the robot with gyro
 * 
 * @author Damon Wagenknecht
 *
 */
public class GyroTurn extends Command {

	private double angle = Robot.drivetrain.AdjustedAngle();
	private double desiredAngle;

	private double newAngle;

	/**
	 * Sets a new angle for the gyro to turn to
	 * 
	 * @param newAngle
	 */
	public GyroTurn(double newAngle) {

		this.newAngle = newAngle;
		Robot.drivetrain.setP(newAngle);
		requires(Robot.drivetrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	/**
	 * Moves the robot to the new angle
	 */
	// Called just before this Command runs the first time
	protected void initialize() {
		desiredAngle = Robot.drivetrain.AdjustedAngle() + newAngle;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (desiredAngle > Robot.drivetrain.AdjustedAngle()) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER,
					Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER);
		} else {
			Robot.drivetrain.tankDrive(Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER,
					-Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER);
		}
	}

	/**
	 * Returns true when angle is in range
	 */
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return (Robot.drivetrain.AdjustedAngle() <= desiredAngle + Constants.AUTO_ANGLE_OFF
				&& Robot.drivetrain.AdjustedAngle() >= desiredAngle + -Constants.AUTO_ANGLE_OFF);
	}

	// daddy trump
	/**
	 * Stops the robot
	 */
	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}

	/**
	 * Stops the robot
	 */
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}

}
