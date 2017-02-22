package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Measures the Distance the Robot has Traveled
 */
public class AutoDrivetrainEncoder extends Command {

	double lastTime;
	double currentDistance;
	double distance;
/**
 * Sets what the Distance is
 * @param distance = How far we want the Robot to go
 */
	public AutoDrivetrainEncoder(double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double RPS = Robot.drivetrain.getLeftEncVelocity() + Robot.drivetrain.getRightEncVelocity() / 2;// needs
																										// to
																										// be
																										// seperated
																										// into
																										// both
																										// side
																										// to
																										// ensure
																										// straight
																										// driving
		double ElapsedTime = timeSinceInitialized() - lastTime;
		lastTime = timeSinceInitialized();
		double currentDistance = Constants.INCHES_PER_ROTATION * RPS * ElapsedTime / 4;
		this.currentDistance += currentDistance;

		Robot.drivetrain.tankDrive(0.5, 0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (currentDistance >= distance);
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
