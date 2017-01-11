package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {// TODO fill in java doc

	public TankDrive() {
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
