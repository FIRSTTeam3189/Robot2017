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
	
	private boolean r = false;
	private boolean flag;

	public DrivetrainTankControl() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.drivetrain.tankDrive(r ? -Robot.oi.getRightY() : Robot.oi.getLeftY(), r ? -Robot.oi.getLeftY() : Robot.oi.getRightY());
		if(Robot.oi.rightOne.get() && !flag){
			flag = true;
			r = !r;
		}else if(flag && !Robot.oi.rightOne.get()){
			flag = false;
		}
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
