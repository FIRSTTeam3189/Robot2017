package org.usfirst.frc.team3189.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private CANTalon leftFront = new CANTalon(0);
	private CANTalon leftMiddle = new CANTalon(0);//TODO map port numbers in robotmap.
	private CANTalon leftBack = new CANTalon(0);
	private CANTalon rightFront = new CANTalon(0);
	private CANTalon rightMiddle = new CANTalon(0);
	private CANTalon rightBack = new CANTalon(0);
	
	public void tankDrive(double left, double right){//TODO add java docs for everything in here including the class.
		leftFront.set(left);
		leftBack.set(left);
		leftMiddle.set(left);
		rightFront.set(right);//TODO right motors need to be oposite of left. use isInverted in contructor. 
		rightMiddle.set(right);
		rightBack.set(right);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//TODO set default command for the drivetrain
    }
}

