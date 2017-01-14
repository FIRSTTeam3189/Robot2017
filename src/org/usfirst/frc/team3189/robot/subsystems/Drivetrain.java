package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This provides a interface for the drivetrain command for the 2017 bot
 * 
 * @author Nate and Nick
 * 
 */
public class Drivetrain extends Subsystem {
	/**
	 * The {@link SpeedController} for the left front motor of the {@link Drivetrain}
	 */
	private CANTalon leftFront = new CANTalon(2);
	
	private CANTalon leftMiddle = new CANTalon(1);
	private CANTalon leftBack = new CANTalon(0);
	private CANTalon rightFront = new CANTalon(5);
	private CANTalon rightMiddle = new CANTalon(4);
	private CANTalon rightBack = new CANTalon(3);
	/**
	 * This inverts the right motors on the robot.
	 */
	public Drivetrain() {
		
		rightFront.setInverted(true);
		rightMiddle.setInverted(true);
		rightBack.setInverted(true);
		
	}
	/**
	 * Sets the speeds of the left and right motors for the tankdrve
	 */
	public void tankDrive(double left, double right){
		
		leftFront.set(left);
		leftBack.set(left);
		leftMiddle.set(left);
		rightFront.set(right);
		rightMiddle.set(right);
		rightBack.set(right);
	}
	/**
	 * Sets the default command to Tankdrive
	 */
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new TankDrive());
    }
}

