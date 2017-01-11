package org.usfirst.frc.team3189.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private CANTalon leftFront = new CANTalon(0);
	private CANTalon leftMiddle = new CANTalon(0);
	private CANTalon leftBack = new CANTalon(0);
	private CANTalon rightFront = new CANTalon(0);
	private CANTalon rightMiddle = new CANTalon(0);
	private CANTalon rightBack = new CANTalon(0);
	
	public void tankDrive(double left, double right){
		leftFront.set(left);
		leftBack.set(left);
		leftMiddle.set(left);
		rightFront.set(right);
		rightMiddle.set(right);
		rightBack.set(right);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

