package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawGoToLow extends Command {

	public ClawGoToLow() {
		requires(Robot.claw);
		requires(Robot.dropper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.dropper.open();
		Robot.claw.open();
		setTimeout(Constants.DROPPER_OPEN_DELAY);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (isTimedOut()) {
			Robot.claw.setPotLow();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.claw.isClawLow();
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
