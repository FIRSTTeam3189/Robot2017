package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	private Piston grabbingPiston = new Piston(RobotMap.grabberExtend,
			RobotMap.grabberRetract);
	private Piston liftingPiston = new Piston(RobotMap.lifterExtend,
			RobotMap.lifterRetract);
	private Talon liftingMotor = new Talon(RobotMap.clawLiftingMotor);

	public void setClawSpeed(double speed) {
		liftingMotor.set(speed);
	}

	public void LiftClaw() {
		liftingPiston.retract();

	}

	public void DropClaw() {
		liftingPiston.extend();
	}

	public void Grab() {
		grabbingPiston.retract();
	}

	public void Release() {
		grabbingPiston.extend();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
