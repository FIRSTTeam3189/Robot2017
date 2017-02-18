package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;
import org.usfirst.frc.team3189.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This provides a interface for the drivetrain command for the 2017 bot
 * 
 * @author Nate and Nick
 * 
 */
public class Drivetrain extends PIDSubsystem {

	private double angle = 0;
	private double gyroError = 0;
	private double xAngle = 0;
	private double xAngleFiltered = 0;

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

	AnalogGyro gyro = new AnalogGyro(RobotMap.GYROSCOPE_PORT);
	BuiltInAccelerometer Accelorometer = new BuiltInAccelerometer();
	Ultrasonic ultrasonic = new Ultrasonic(RobotMap.ULTRASONIC_PORT, 1);

	public Drivetrain() {
		super(Constants.tuneP, Constants.tuneI, Constants.tuneD);
		ultrasonic.setAutomaticMode(true);
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

	public double SonarPing() {
		return ultrasonic.getRangeInches();
	}

	/**
	 * Sets the default command to Tankdrive
	 */
	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public double AdjustedAngle() {
		xAngle = Math.toDegrees(Accelorometer.getX());
		// (getAxesMeasurements().XAxis);
		xAngleFiltered = RobotMap.HFC * xAngleFiltered + (1 - RobotMap.HFC) * xAngle;
		gyroError = xAngleFiltered - gyro.getAngle();
		// Get the actual Angle of the bot
		angle = RobotMap.LFC * ((angle + (gyro.getAngle() + gyroError)) / 2) + (1 - RobotMap.LFC) * xAngle;

		return angle;
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drivetrain.tankDrive(output, -output);

	}
	
	public void setP(double desiredAngle) {
		
		getPIDController().setPID(1.0 / (Math.abs(AdjustedAngle() - desiredAngle)), Constants.tuneI, Constants.tuneD);
		
	}
	
	public void updateStatus(){
		SmartDashboard.putNumber("leftone", leftBack.getOutputVoltage());
		SmartDashboard.putNumber("lefttwo", leftFront.getOutputVoltage());
		SmartDashboard.putNumber("leftthree", leftMiddle.getOutputVoltage());
		SmartDashboard.putNumber("rightone", rightBack.getOutputVoltage());
		SmartDashboard.putNumber("righttwo", rightMiddle.getOutputVoltage());
		SmartDashboard.putNumber("rightthree", rightFront.getOutputVoltage());
		SmartDashboard.putNumber("gyro", gyro.getAngle());
		SmartDashboard.putNumber("accel", Accelorometer.getX());
		SmartDashboard.putNumber("ajust", this.AdjustedAngle());
	}
	
}
