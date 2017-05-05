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
	public static double visionScalerRange = 0.5;
	public static double visionScalerConstant = 0.1;

	public AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(double stopDistance) {
		requires(Robot.drivetrain);
		this.stopDistance = stopDistance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	double speedL = -Constants.AUTO_VISION_SPEED;
    	double speedR = -Constants.AUTO_VISION_SPEED;
    	double thingy = Robot.vision.getPixelsOff();
		if(Robot.vision.hasUpdated()){
			if (thingy >= Constants.AUTO_VISION_RANGE) {
				speedR *= (visionScalerRange*(thingy/320)) + visionScalerConstant;
			} else if (thingy <= -Constants.AUTO_VISION_RANGE) {
				speedL *= (visionScalerRange*(thingy/320)) + visionScalerConstant;
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
