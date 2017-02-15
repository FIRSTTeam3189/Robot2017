package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardSonar extends Command {

	double stopDistance;
	
	public DriveForwardSonar(double stopDistance) {
		requires(Robot.drivetrain);
		this.stopDistance = stopDistance;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.tankDrive(RobotMap.AUTO_DRIVE_SPEED,RobotMap.AUTO_DRIVE_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (stopDistance <= Robot.drivetrain.SonarPing());
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.tankDrive(0, 0);
	}
}
