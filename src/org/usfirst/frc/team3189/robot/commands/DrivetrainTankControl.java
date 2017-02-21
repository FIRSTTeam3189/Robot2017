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
public class DrivetrainTankControl extends Command {

	public DrivetrainTankControl() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.drivetrain.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}

	protected void interrupted() {

		Robot.drivetrain.tankDrive(0, 0);
	}
}
