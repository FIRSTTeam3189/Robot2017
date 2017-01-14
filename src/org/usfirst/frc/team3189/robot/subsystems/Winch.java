package org.usfirst.frc.team3189.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	@author Trent, Nate
 */
public class Winch extends Subsystem {
	private CANTalon winchMotor = new CANTalon(0);

	/**
	 * 
	 * @param speed sets the speed of the winch
	 */
	public void setWinchspeed(double speed) {
		winchMotor.set(speed);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
