package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.AnalogUltrasonic;
import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.commands.DrivetrainTankControl;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This provides a interface for the drivetrain command for the 2017 bot
 * 
 * @author Nate and Nick
 * 
 */
public class Drivetrain extends Subsystem {

	double lastTime;
	double rightDistance;
	double leftDistance;
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

	AnalogGyro gyro = new AnalogGyro(RobotMap.GYROSCOPE_PORT);
	BuiltInAccelerometer Accelorometer = new BuiltInAccelerometer();
	AnalogUltrasonic sonic = new AnalogUltrasonic(RobotMap.ULTRASONIC_PORT);

	public Drivetrain() {
		gyro.reset();
		leftFront.setInverted(true);
		leftMiddle.setInverted(true);
		leftBack.setInverted(true);
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
	 * gets the distance read by the ultrasonic sensor
	 * 
	 * @return distance from object in inches
	 */
	public double sonarPing() {
		return sonic.getInches();
	}

	/**
	 * Sets the default command to Tankdrive
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new DrivetrainTankControl());
	}

	/**
	 * Gets the current angle of the Robot.
	 * 
	 * @return double the angle at which the robot is pointing
	 */
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro(){
		gyro.reset();
	}
	
	public double getRightDistance() {
		return rightFront.getEncPosition() / Constants.ENCODER_TICKS_PER_INCH;
	}

	public double getLeftDistance() {
		return leftBack.getEncPosition() / Constants.ENCODER_TICKS_PER_INCH;
	}

	public void resetDistance(){
		leftDistance = 0;
		rightDistance = 0;
		rightFront.setEncPosition(0);
		leftBack.setEncPosition(0);
	}

	/**
	 * sends values of this system to smartdashboard
	 */
	public void updateStatus() {
//		SmartDashboard.putNumber("leftone", leftBack.getOutputVoltage());
//		SmartDashboard.putNumber("lefttwo", leftFront.getOutputVoltage());
//		SmartDashboard.putNumber("leftthree", leftMiddle.getOutputVoltage());
//		SmartDashboard.putNumber("rightone", rightBack.getOutputVoltage());
//		SmartDashboard.putNumber("righttwo", rightMiddle.getOutputVoltage());
//		SmartDashboard.putNumber("rightthree", rightFront.getOutputVoltage());
		SmartDashboard.putNumber("Ultrasonic sensor	", sonarPing());
		SmartDashboard.putNumber("accel", Accelorometer.getX());
		SmartDashboard.putNumber("gyro", getGyroAngle());
		SmartDashboard.putNumber("LeftEnoderInches", getLeftDistance());
		SmartDashboard.putNumber("RightEnoderInches", getRightDistance());
		SmartDashboard.putNumber("Distance", (getLeftDistance() + getRightDistance())/2);
		
	}
}
