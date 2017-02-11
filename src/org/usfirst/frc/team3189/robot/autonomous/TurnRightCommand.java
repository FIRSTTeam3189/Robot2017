package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes the robot turn left during Autonomous
 * @author Damon Wagenknecht
 *
 */
public class TurnRightCommand extends Command {

	/**
	 * Sets how long the robot moves and does stuff during Autonomous
	 */
	
	public double time;
	
	/**
	 * Turns the robot right
	 * 
	 * @param time
	 * time = how long robot turns right
	 */
    public TurnRightCommand(double time) {
    	
    	requires(Robot.drivetrain);
    	
    	this.time = time;
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    /**
     * Sets how long the robot will turn right
     */
    protected void initialize() {
    	
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Sets the speed of the robot
     */
    protected void execute() {
    	
    	Robot.drivetrain.tankDrive(-Constants.AUTO_FORWARD_SPEED, Constants.AUTO_FORWARD_SPEED);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * Stops the robot
     */
    protected void interrupted() {

    	Robot.drivetrain.tankDrive(0, 0);
    }
}