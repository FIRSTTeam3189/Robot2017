package org.usfirst.frc.team3189.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftjoystick = new Joystick(0);
	private Joystick rightjoystick = new Joystick(1);
	private Joystick launcherjoystick = new Joystick(2);//TODO what launcher?

	public double getLeftY() {//TODO DOCUMENTATION
		return leftjoystick.getY();
	}

	public double getRightY() {
		return rightjoystick.getY();
	}
}
