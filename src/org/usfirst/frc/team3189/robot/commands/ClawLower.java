package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Lowers the claw of the Robot.
 * 
 * @author Alex Rodgers
 */
public class ClawLower extends Command {

	public ClawLower() {
		requires(Robot.claw);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.claw.setLifterSpeed(Constants.CLAW_LOWER_SPEED);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.claw.isLowerSwitch();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.claw.setLifterSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.claw.setLifterSpeed(0);
	}
}
