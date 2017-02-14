package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *  Moves the robot backwards
 *  
 *  @author Alex Rodgers
 */
public class ReverseDirectionCommand extends Command {
	
	/**
	 * How long the motors will be on.
	 */
	public double time;
	
	/**
	 * Reverses the wheels on the bot.
	 * 
	 * @param time how long the wheels will be reversing.
	 */
    public ReverseDirectionCommand(double time) {
        
    	requires(Robot.drivetrain);
    	this.time = time;
    }

    // Called just before this Command runs the first time
    /**
     * Sets time until timeout.
     */
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Sends power to the motor controllers.
     */
    protected void execute() {
    	Robot.drivetrain.tankDrive(-Constants.AUTO_REVERSE_SPEED, -Constants.AUTO_REVERSE_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Checks to see if the robot is done moving backwards.
     */
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * Stops the robot.
     */
    protected void interrupted() {
    	Robot.drivetrain.tankDrive(0, 0);
    }
}
