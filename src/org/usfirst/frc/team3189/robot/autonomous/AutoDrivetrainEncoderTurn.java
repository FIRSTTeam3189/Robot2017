package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives forward using encoders
 * 
 * @author Nathaniel Mansfield
 */
public class AutoDrivetrainEncoderTurn extends Command {

	double distance;

	/**
	 * uses encoders to drive forward a provided distance distance
	 * 
	 * @param distance
	 *            in inches
	 */
	public AutoDrivetrainEncoderTurn(double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.resetDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Robot.drivetrain.getRightDistance() > distance){
			Robot.drivetrain.tankDrive(0.35, -0.35);
		}else if(Robot.drivetrain.getRightDistance() < distance){
			Robot.drivetrain.tankDrive(-0.35, 0.35);
		}else{
			Robot.drivetrain.tankDrive(0, 0);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double avg = (Math.abs(Robot.drivetrain.getRightDistance()) + Math.abs(Robot.drivetrain.getLeftDistance())) / 2;
		return (avg >= -distance - 3) && (avg <= -distance + 3);
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
