package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.autonomous.Constants;
import org.usfirst.frc.team3189.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * This provides a interface for the drivetrain command for the 2017 bot
 * 
 * @author Nate and Nick
 * 
 */
public class Drivetrain extends Subsystem {

	private double angle = 0;
	private double gyroError = 0;
	private double speed = 0;
	private double speedReal = 0;
	private double xAngle = 0;
	private double xAngleFiltered = 0;
	private double prev = angle;
	private double difference = 0;

	/**
	 * {@link SpeedController} for the left front motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon leftFront = new CANTalon(RobotMap.LEFT_FRONT);
	/**
	 * {@link SpeedController} for the left middle motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon leftMiddle = new CANTalon(RobotMap.LEFT_MIDDLE);
	/**
	 * {@link SpeedController} for the left back motor of the {@link Drivetrain}
	 */
	private CANTalon leftBack = new CANTalon(RobotMap.LEFT_BACK);
	/**
	 * {@link SpeedController} for the right front motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon rightFront = new CANTalon(RobotMap.RIGHT_FRONT);
	/**
	 * {@link SpeedController} for the right middle motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon rightMiddle = new CANTalon(RobotMap.RIGHT_MIDDLE);
	/**
	 * {@link SpeedController} for the right back motor of the
	 * {@link Drivetrain}
	 */
	private CANTalon rightBack = new CANTalon(RobotMap.RIGHT_BACK);

	/**
	 * This inverts the right motors on the robot.
	 */
	
	AnalogGyro gyro = new AnalogGyro(0);
	PIDLoop loop = new PIDLoop(Constants.tuneP, Constants.tuneI, Constants.tuneD);
	

	public Drivetrain() {
		gyro.reset();
		rightFront.setInverted(true);
		rightMiddle.setInverted(true);
		rightBack.setInverted(true);

	}

	/**
	 * Set's speed of Motors of tankDrive
	 * 
	 * @param left
	 *            double set left side Motor speed
	 * @param right
	 *            double set right side Motor Speed
	 */
	public void tankDrive(double left, double right) {

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
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}
	
	public double AdjustedAngle(){
		xAngle = Math.toDegrees(Robot.Acceloremeter.getAcceloremeterAcceleration());
				//(getAxesMeasurements().XAxis);
		xAngleFiltered = RobotMap.HFC * xAngleFiltered + (1 - RobotMap.HFC)
				* xAngle;
		gyroError = xAngleFiltered - Robot.gyroscope.getGyroAngle();
		// Get the actual Angle of the bot
		angle = RobotMap.LFC
				* ((angle + (Robot.gyroscope.getGyroAngle() + gyroError)) / 2)
				+ (1 - RobotMap.LFC) * xAngle;
		
		speedReal = angle / RobotMap.SPEED_DIV;
		difference=angle-prev;
		
		return angle;
	}
	
	public void changeAngle(double newAngle) {
		loop.usePIDOutput(newAngle);	
	}
	
}
