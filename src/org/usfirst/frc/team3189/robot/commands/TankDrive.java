package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot
 *@author Deez Nuts and Alex and Harambe
 */
public class TankDrive extends Command {// TODO fill in java doc
/**
 * 
 */
	public TankDrive() {
		/**
		 * Uses the Robots drivetrain's subsystem
		 */
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}
	
	protected void execute() {
		/**
		 * Get speed from Joysticks and Drives bot
		 */
		Robot.drivetrain.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end(){
		/**
		 * Stops the robot when their is no input from the Joysticks
		 */
		
		Robot.drivetrain.tankDrive(0, 0);
	}
	
	protected void interrupted() {
		/**
		 * Stops the robot when another Command is called
		 */
		Robot.drivetrain.tankDrive(0, 0);
	}
}
