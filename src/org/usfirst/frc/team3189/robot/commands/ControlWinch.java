package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlWinch extends Command {
	/**
	 * Uses the winch subsystem
	 */
	public ControlWinch() {
		requires(Robot.winch);

	}

	protected void initialize() {
	}

	/**
	 * gets speed from copilot's joystick and controls the winch
	 */
	protected void execute() {
		Robot.winch.setWinchspeed(Robot.oi.getCoPilotJoystickY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

/**
 * sets speed of winch to 0 when command ends
 */
	protected void end() {
		Robot.winch.setWinchspeed(0);
	}

/**
 * sets the speed of the winch to zero if the command is inturupted
 */
	protected void interrupted() {
		Robot.winch.setWinchspeed(0);
	}
}
