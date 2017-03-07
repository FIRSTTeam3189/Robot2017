package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	private Piston clawPiston = new Piston(RobotMap.CLAW_OPEN, RobotMap.CLAW_CLOSED, false);
	private Piston extensionPiston = new Piston(RobotMap.CLAW_EXTENDER_EXTEND, RobotMap.CLAW_EXTENDER_RETRACT);
	private Talon liftingMotor = new Talon(RobotMap.CLAW_LIFTING_MOTOR);
	private DigitalInput upperSwitch = new DigitalInput(RobotMap.UPPER_LIMIT_SWITCH);
	private DigitalInput lowerSwitch = new DigitalInput(RobotMap.LOWER_LIMIT_SWITCH);
	private AnalogPotentiometer potentiometer = new AnalogPotentiometer(0);

	/**
	 * sets the speed of the motor controlling the position of the claw.
	 * 
	 * @param speed
	 *            -1 through zero lowers, 0 through 1 lifts
	 */
	public void setLifterSpeed(double speed) {
		liftingMotor.set(speed);
	}

	/**
	 * extends the claw extension used for getting the gear closer the the front
	 * of the robot. . /!\ DO NOT USE WHEN CLAW IS IN LOW POSITION /!\
	 */
	public void extend() {
		extensionPiston.retract();
	}

	/**
	 * retracts the claw extension so the claw can go into the low position and
	 * pick up a gear.
	 */
	public void retract() {
		extensionPiston.extend();
	}

	/**
	 * opens the claw so we can collect a gear.
	 */
	public void open() {
		clawPiston.extend();
	}

	/**
	 * closes the claw to grip what is between it.
	 */
	public void close() {
		clawPiston.retract();
	}

	/**
	 * toggles the claws between open and closed.
	 */
	public void toggleClaw() {
		clawPiston.toggle();
	}

	/**
	 * toggles the claw extension to extended or retracted.
	 */
	public void toggleExtention() {
		extensionPiston.toggle();
	}

	public void initDefaultCommand() {
	}

	public boolean isUpperSwitch() {
		return upperSwitch.get();
	}

	public boolean isLowerSwitch() {
		return lowerSwitch.get();
	}

	public void getPot() {
		potentiometer.get();
	}

	public void setPotHigh() {
		if (potentiometer.get() < Constants.POTENTIOMETER_TOP - 2) {
			liftingMotor.set(0.5);
		} else if (potentiometer.get() < Constants.POTENTIOMETER_TOP + 2) {
			liftingMotor.set(-0.5);
		} else {
			liftingMotor.set(0);
		}
	}

	public void setPotMid() {
		if (potentiometer.get() < Constants.POTENTIOMETER_MIDDLE - 2) {
			liftingMotor.set(0.5);
		} else if (potentiometer.get() < Constants.POTENTIOMETER_MIDDLE + 2) {
			liftingMotor.set(-0.5);
		} else {
			liftingMotor.set(0);
		}
	}

	public void setPotLow() {
		if (potentiometer.get() < Constants.POTENTIOMETER_BOTTOM - 2) {
			liftingMotor.set(0.5);
		} else if (potentiometer.get() < Constants.POTENTIOMETER_BOTTOM + 2) {
			liftingMotor.set(-0.5);
		} else {
			liftingMotor.set(0);
		}
	}
}
