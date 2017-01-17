package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Piston;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	private Piston grabbingPiston = new Piston(0, 0);
	private Piston liftingPiston = new Piston(0, 0);
	
	
	
	public void LiftClaw(){
		liftingPiston.retract();
	}
	public void DropClaw(){
		liftingPiston.extend();
	}
	
	public void Grab(){
		grabbingPiston.retract();
	}
	public void Release(){
		grabbingPiston.extend();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

