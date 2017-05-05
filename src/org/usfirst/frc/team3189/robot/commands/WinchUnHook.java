package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchUnHook extends Command {

	public WinchUnHook() {
		requires(Robot.winch);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(3);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.winch.setWinchspeed(Constants.CLIMB_SPEED*0.66);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.winch.setWinchspeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.winch.setWinchspeed(0);
	}
}
