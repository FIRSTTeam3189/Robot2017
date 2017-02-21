package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns the robot with gyro
 * 
 * @author Damon Wagenknecht
 */
public class AutoDrivetrainGyroTurn extends Command {

	private double angle = Robot.drivetrain.getGyroAngle();
	private double desiredAngle;
	private double newAngle;

	/**
	 * Sets a new angle for the gyro to turn to
	 * 
	 * @param newAngle
	 */
	public AutoDrivetrainGyroTurn(double newAngle) {
		this.newAngle = newAngle;
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		desiredAngle = Robot.drivetrain.getGyroAngle() + newAngle;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (desiredAngle > Robot.drivetrain.getGyroAngle()) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER,
					Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER);
		} else {
			Robot.drivetrain.tankDrive(Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER,
					-Constants.AUTO_DRIVE_SPEED * Constants.GYRO_SPEED_MULTIPLIER);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return (Robot.drivetrain.getGyroAngle() <= desiredAngle + Constants.AUTO_ANGLE_OFF
				&& Robot.drivetrain.getGyroAngle() >= desiredAngle + -Constants.AUTO_ANGLE_OFF);
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
