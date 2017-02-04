package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Dropper extends Subsystem {
	
	private Piston piston = new Piston(RobotMap.dropperExtend,RobotMap.dropperRetract);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void OpenDropper(){
		piston.extend();
	}
	
	public void CloseDropper(){
		piston.retract();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

