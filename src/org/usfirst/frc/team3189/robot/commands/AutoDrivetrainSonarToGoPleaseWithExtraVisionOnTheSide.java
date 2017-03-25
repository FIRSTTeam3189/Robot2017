package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide extends Command {

	/**
	 * Stop's once value is reached
	 */
	double stopDistance;
	public static double MULTI = 0.65;

	public AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(double stopDistance) {
		requires(Robot.drivetrain);
		this.stopDistance = stopDistance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	double speedL = -Constants.AUTO_FORWARD_SPEED;
    	double speedR = -Constants.AUTO_FORWARD_SPEED;
    	double thingy = Robot.vision.getPegBase();
		if(Robot.vision.isGood()){
			if (thingy >= Constants.AUTO_VISION_RANGE) {
				speedR *= MULTI;
			} else if (thingy <= -Constants.AUTO_VISION_RANGE) {
				speedL *= MULTI;
			}
		}
		Robot.drivetrain.tankDrive(speedL,speedR);

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
