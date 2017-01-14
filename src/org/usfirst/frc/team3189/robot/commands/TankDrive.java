package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot
 * 
 * @author Deez Nuts and Alex and Harambe
 */

public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	/**
	 * Get speed from Joysticks and drives bot.
	 */
	protected void execute() {
		Robot.drivetrain.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}

	/**
	 * Stops the robot when another command is called.
	 */
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}
}
