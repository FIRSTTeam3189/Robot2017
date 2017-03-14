package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawGoToMid extends Command {

	public ClawGoToMid() {
		requires(Robot.claw);
		requires(Robot.dropper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.dropper.open();
		Robot.claw.close();
		setTimeout(Constants.DROPPER_OPEN_DELAY);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (isTimedOut()) {
			Robot.claw.setPotMid();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.claw.isClawReadyForHang();
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
