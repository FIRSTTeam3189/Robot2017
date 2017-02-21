package org.usfirst.frc.team3189.robot;

import org.usfirst.frc.team3189.robot.commands.GearboxHigh;
import org.usfirst.frc.team3189.robot.commands.DropperToggle;

import edu.wpi.first.wpilibj.Joystick;
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
	private JoystickButton leftOne = new JoystickButton(leftjoystick, 1);
	private JoystickButton leftTwo = new JoystickButton(leftjoystick, 2);
//	private JoystickButton leftThree = new JoystickButton(leftjoystick, 3);
//	private JoystickButton leftFour = new JoystickButton(leftjoystick, 4);
//	private JoystickButton leftFive = new JoystickButton(leftjoystick, 5);
//	private JoystickButton leftSix = new JoystickButton(leftjoystick, 6);
//	private JoystickButton leftSeven = new JoystickButton(leftjoystick, 7);
//	private JoystickButton leftEight = new JoystickButton(leftjoystick, 8);
//	private JoystickButton leftNine = new JoystickButton(leftjoystick, 9);
//	private JoystickButton leftTen = new JoystickButton(leftjoystick, 10);
//	private JoystickButton rightFour = new JoystickButton(rightjoystick, 4);
//	private JoystickButton rightFive = new JoystickButton(rightjoystick, 5);
//	private JoystickButton rightThree = new JoystickButton(rightjoystick, 3);
//	private JoystickButton rightOne = new JoystickButton(rightjoystick, 1);

	public OI() {
		leftOne.whileHeld(new GearboxHigh());// Hold the left trigger to be in
												// high gear
		leftTwo.whenPressed(new DropperToggle());
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
	 * returns the value from the right Joystick with a range of 1.0 - -1.0.
	 * 
	 * @return Double Right joy stick Value
	 */
	public double getRightY() {
		/**
		 * Sets the right joystick to get the Y axis
		 */
		return rightjoystick.getY();
	}

	/**
	 * returns the value of the copilot's joystick with a range of 1.0 to -1.0.
	 * 
	 * @return Double copilot's joystick value
	 */
	public double getCoPilotJoystickY() {
		return grabjoystick.getY();
	}
}