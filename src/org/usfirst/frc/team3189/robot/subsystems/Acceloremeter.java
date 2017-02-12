package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Acceloremeter extends Subsystem {
	
	private AnalogAccelerometer Accelerometer = new AnalogAccelerometer(RobotMap.ACCELEREMETER_PORT);
	
	
	public double getAcceloremeterAcceleration(){
		return Accelerometer.getAcceleration();
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

