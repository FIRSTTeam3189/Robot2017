package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Hangs the gear
 * 
 * @author Damon Wagenknecht
 *
 */
public class AutoVisionDrive extends Command {

	public AutoVisionDrive() {
		requires(Robot.drivetrain);
		requires(Robot.vision);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double thingy = Robot.vision.getPegBase();
		if (thingy >= Constants.AUTO_VISION_RANGE) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_VISION_SPEED, Constants.AUTO_VISION_SPEED);
		} else if (thingy <= -Constants.AUTO_VISION_RANGE) {
			Robot.drivetrain.tankDrive(Constants.AUTO_VISION_SPEED, -Constants.AUTO_VISION_SPEED);
		}else{
			Robot.drivetrain.tankDrive(0, 0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Robot.vision.getPegBase() <= Constants.AUTO_VISION_RANGE && Robot.vision.getPegBase() >= -Constants.AUTO_VISION_RANGE);
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
