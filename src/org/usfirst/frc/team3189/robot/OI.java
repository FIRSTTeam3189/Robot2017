package org.usfirst.frc.team3189.robot;

import org.usfirst.frc.team3189.robot.commands.ControlWinch;
import org.usfirst.frc.team3189.robot.commands.ShiftDown;
import org.usfirst.frc.team3189.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	// joystick button number not finalized
	private JoystickButton shiftGears = new JoystickButton(leftjoystick, 1);
	private JoystickButton shiftUp = new JoystickButton(leftjoystick, 2);
	private JoystickButton shiftDown = new JoystickButton(leftjoystick, 3);
	private JoystickButton winchButton = new JoystickButton(leftjoystick, 4);

	public OI() {
		shiftDown.whenPressed(new ShiftDown());
		shiftUp.whenPressed(new ShiftUp());
		winchButton.toggleWhenPressed(new ControlWinch());
	}

	/**
	 * returns the value from the left hoystick with a range of 1.0 - -1.0.
	 * 
	 * @return Double left joy stick vlaue
	 */
	public double getLeftY() {
		return leftjoystick.getY();
	}

	/**
	 * returns the value from the left Joystick with a range of 1.0 - -1.0.
	 * 
	 * @return Double Right joy stick Value
	 */
	public double getRightY() {
		/**
		 * Sets the right joystick to get the Y axis
		 */
		return rightjoystick.getY();
	}
}