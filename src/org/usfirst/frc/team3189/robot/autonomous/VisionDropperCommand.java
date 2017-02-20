package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Hangs the gear
 * @author Damon Wagenknecht
 *
 */
public class VisionDropperCommand extends Command {

	public VisionDropperCommand() {
		requires(Robot.drivetrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}
/**
 * Moves the robot towards the target
 */
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double thingy = Robot.vision.getTheThing();
		if (thingy >= 10) {
			Robot.drivetrain.tankDrive(-Constants.AUTO_VISION_SPEED, Constants.AUTO_VISION_SPEED);
		} else if (thingy <= -10) {
			Robot.drivetrain.tankDrive(Constants.AUTO_VISION_SPEED, -Constants.AUTO_DRIVE_SPEED);
		}

	}
/**
 * Determine if the robot is in range
 */
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Robot.vision.getTheThing() <= 10 && Robot.vision.getTheThing() >= -10);
	}
/**
 * stops the robot
 */
	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}
/**
 * stops the robot
 */
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}
}
