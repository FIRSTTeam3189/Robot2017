package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurnRight extends Command {

	private double angle = Robot.gyroscope.getGyroAngle();
	
    public GyroTurnRight() {
    	
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.drivetrain.changeAngle(90.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.gyroscope.getGyroAngle() <= angle + 90.5 && Robot.gyroscope.getGyroAngle() >= angle + 89.5);
        
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
