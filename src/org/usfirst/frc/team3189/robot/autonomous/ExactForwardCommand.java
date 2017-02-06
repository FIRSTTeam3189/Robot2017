package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExactForwardCommand extends Command {

	public boolean isDone = false;
    public ExactForwardCommand() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.drivetrain.leftFrontEncoderPos() < Constants.MAX_ENCODER_DISTANCE) {
    		Robot.drivetrain.tankDrive(-Constants.AUTO_FORWARD_SPEED, Constants.AUTO_FORWARD_SPEED);
    	}
    	isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.tankDrive(0, 0);
    }
}
