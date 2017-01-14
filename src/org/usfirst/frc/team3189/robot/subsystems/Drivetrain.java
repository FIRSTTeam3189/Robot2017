package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;
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
	 * The {@link SpeedController} for the left front motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon leftFront = new CANTalon(RobotMap.leftFront);
	
	private CANTalon leftMiddle = new CANTalon(RobotMap.leftMiddle);
	private CANTalon leftBack = new CANTalon(RobotMap.leftBack);
	private CANTalon rightFront = new CANTalon(RobotMap.rightFront);
	private CANTalon rightMiddle = new CANTalon(RobotMap.rightMiddle);
	private CANTalon rightBack = new CANTalon(RobotMap.rightBack);

	public Drivetrain() {
		/**
		 * This inverts the right motors on the robot.
		 */
		rightFront.setInverted(true);
		rightMiddle.setInverted(true);
		rightBack.setInverted(true);

	}

	public void tankDrive(double left, double right) {
		/**
		 * Sets the speeds of the left and right motors for the tankdrve
		 */
		leftFront.set(left);
		leftBack.set(left);
		leftMiddle.set(left);
		rightFront.set(right);
		rightMiddle.set(right);
		rightBack.set(right);
	}

	public void initDefaultCommand() {
		/**
		 * Sets the default command to Tankdrive
		 */
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

		setDefaultCommand(new TankDrive());
	}
}
