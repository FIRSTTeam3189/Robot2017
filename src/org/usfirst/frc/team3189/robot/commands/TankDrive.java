/**
 * Drives the robot
 * 
 * @author Damon and Alex and Nick
 */
package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Uses the Robots drivetrain's subsystem
 */
public class TankDrive extends Command {
	public TankDrive() {

		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	/**
	 * Get speed from Joysticks and Drives bot
	 */
	protected void execute() {

		Robot.drivetrain.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
	}

	protected boolean isFinished() {
		return false;
	}
	
	/**
	 * Stops the robot when their is no input from the Joysticks
	 */
	protected void end() {

		Robot.drivetrain.tankDrive(0, 0);
	}

	/**
	 * Stops the robot when another Command is called
	 */
	protected void interrupted() {

		Robot.drivetrain.tankDrive(0, 0);
	}
}
