package org.usfirst.frc.team3189.robot;

import org.usfirst.frc.team3189.robot.commands.ControlWinch;
import org.usfirst.frc.team3189.robot.commands.ShiftDown;
import org.usfirst.frc.team3189.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Provides a map for all operator interfaces
 * @author Damon Wagenknecht
 *
 */
public class OI {
	private Joystick leftjoystick = new Joystick(0);
	private Joystick rightjoystick = new Joystick(1);
	private Joystick grabjoystick = new Joystick(2);
	//joystick button number not finalized
	public JoystickButton shiftGears = new JoystickButton(leftjoystick, 1);
	public JoystickButton shiftUp = new JoystickButton(leftjoystick, 2);
	public JoystickButton shiftDown = new JoystickButton(leftjoystick, 3);
	public JoystickButton activateWinch = new JoystickButton(leftjoystick, 5);
	
	public OI() {
		shiftDown.whenPressed(new ShiftDown());
		shiftUp.whenPressed(new ShiftUp());
		activateWinch.toggleWhenPressed(new ControlWinch());
		
	}

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
