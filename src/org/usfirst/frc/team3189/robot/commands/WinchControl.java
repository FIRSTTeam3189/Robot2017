package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Controls the Winch
 * @author Nicholas
 */
public class WinchControl extends Command {

	public WinchControl() {
		requires(Robot.winch);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.winch.setWinchspeed(Robot.oi.getCoPilotJoystickY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.winch.setWinchspeed(0);
	}

	protected void interrupted() {
		Robot.winch.setWinchspeed(0);
	}
}
