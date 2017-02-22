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

	/**
	 * Gets the velocity of the left side of the Robot.
	 * 
	 * @return the velocity in encoder ticks of the left side of the bot.
	 */
	public double getLeftEncVelocity() {
		return leftFront.getEncVelocity();
	}

	/**
	 * Gets the velocity of the right side of the Robot.
	 * 
	 * @return the velocity in encoder ticks of the right side of the bot.
	 */
	public double getRightEncVelocity() {
		return rightBack.getEncVelocity();
	}

	/**
	 * Sets the encoder ticks of the wheels per revolution
	 */
	public void setEncoderRevs() {
		leftFront.configEncoderCodesPerRev(Constants.ENCODER_ACCURACY);
		rightBack.configEncoderCodesPerRev(Constants.ENCODER_ACCURACY);
	}
	public void updateDistance(){
		double rightEncVelocity = rightBack.getEncPosition();
		double leftEncVelocity = leftFront.getEncPosition();
		
		double tempLeft, tempRight = 0;
		tempLeft = (leftEncVelocity*Constants.INCHES_PER_ROTATION) / (Robot.gearbox.isLowGear() ? Constants.LOW_GEARING_RATIO :Constants.HIGH_GEARING_RATIO);
		tempRight = (rightEncVelocity*Constants.INCHES_PER_ROTATION) / (Robot.gearbox.isLowGear() ? Constants.LOW_GEARING_RATIO :Constants.HIGH_GEARING_RATIO);
		
		leftDistance += tempLeft;
		rightDistance += tempRight;
	}
	
	public double getRightDistance() {
		return rightDistance;
	}

	public double getLeftDistance() {
		return leftDistance;
	}

	public void resetDistance(){
		leftDistance = 0;
		rightDistance = 0;
	}

	/**
	 * sends values of this system to smartdashboard
	 */
	public void updateStatus() {
		SmartDashboard.putNumber("leftone", leftBack.getOutputVoltage());
		SmartDashboard.putNumber("lefttwo", leftFront.getOutputVoltage());
		SmartDashboard.putNumber("leftthree", leftMiddle.getOutputVoltage());
		SmartDashboard.putNumber("rightone", rightBack.getOutputVoltage());
		SmartDashboard.putNumber("righttwo", rightMiddle.getOutputVoltage());
		SmartDashboard.putNumber("rightthree", rightFront.getOutputVoltage());
		SmartDashboard.putNumber("Ultrasonic sensor	", sonarPing());
		SmartDashboard.putNumber("gyro", gyro.getAngle());
		SmartDashboard.putNumber("accel", Accelorometer.getX());
		SmartDashboard.putNumber("ajust", getGyroAngle());
		SmartDashboard.putNumber("left y", Robot.oi.getLeftY());
		SmartDashboard.putNumber("right y", Robot.oi.getRightY());
		SmartDashboard.putNumber("left Encoder", getLeftEncVelocity());
		SmartDashboard.putNumber("Right Encoder", getRightEncVelocity());
		SmartDashboard.putNumber("Left Enc Pos", leftFront.getEncPosition());
		SmartDashboard.putNumber("Right Enc Pos", rightBack.getEncPosition());
		
		
	}
}
