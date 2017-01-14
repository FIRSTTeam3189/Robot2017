package org.usfirst.frc.team3189.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Provides a map for all operator interfaces
 * 
 * @author Damon Wagenknecht
 *
 */
public class OI {
	private Joystick leftjoystick = new Joystick(0);
	private Joystick rightjoystick = new Joystick(1);
	private Joystick grabjoystick = new Joystick(2);

	public double getLeftY() {
		/**
		 * Sets the left joystick to get the Y axis
		 */
		return leftjoystick.getY();
	}

	public double getRightY() {
		/**
		 * Sets the right joystick to get the Y axis
		 */
		return rightjoystick.getY();
	}
}
