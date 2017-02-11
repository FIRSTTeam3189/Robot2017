package org.usfirst.frc.team3189.robot.subsystems;

import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.autonomous.Constants;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PIDLoop extends PIDSubsystem {

	
	
    public PIDLoop(double p, double i, double d) {
		super(p, i, d);
		// TODO Auto-generated constructor stub
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
}

