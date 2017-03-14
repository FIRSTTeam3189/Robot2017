package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives forward using encoders
 * 
 * @author Nathaniel Mansfield
 */
public class AutoDrivetrainEncoder extends Command {

	double distance;

	/**
	 * uses encoders to drive forward a provided distance distance
	 * 
	 * @param distance
	 *            in inches
	 */
	public AutoDrivetrainEncoder(double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.resetDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.drivetrain.getRightDistance() + 2 < Robot.drivetrain.getLeftDistance()) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_DRIVE_SPEED * 0.9, -Constants.AUTO_DRIVE_SPEED);
		} else if (Robot.drivetrain.getLeftDistance() + 2 < Robot.drivetrain.getRightDistance()) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_DRIVE_SPEED, -Constants.AUTO_DRIVE_SPEED * 0.9);
		} else {
			Robot.drivetrain.tankDrive(-Constants.AUTO_DRIVE_SPEED, -Constants.AUTO_DRIVE_SPEED);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double avg = (Robot.drivetrain.getRightDistance() + Robot.drivetrain.getLeftDistance()) / 2;
		return (avg >= distance - 2) && (avg <= distance + 2);
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
