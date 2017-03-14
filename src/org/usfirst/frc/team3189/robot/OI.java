package org.usfirst.frc.team3189.robot;

import org.usfirst.frc.team3189.robot.commands.GearboxHigh;
import org.usfirst.frc.team3189.robot.commands.WinchControl;
import org.usfirst.frc.team3189.robot.commands.WinchLift;
import org.usfirst.frc.team3189.robot.commands.WinchLower;
import org.usfirst.frc.team3189.robot.autonomous.AutoDrivetrainReverse;
import org.usfirst.frc.team3189.robot.commands.AutoDropperOpen;
import org.usfirst.frc.team3189.robot.commands.AutoDropperToggle;
import org.usfirst.frc.team3189.robot.commands.ClawControl;
import org.usfirst.frc.team3189.robot.commands.ClawGoToHigh;
import org.usfirst.frc.team3189.robot.commands.ClawGoToLow;
import org.usfirst.frc.team3189.robot.commands.ClawGoToMid;
import org.usfirst.frc.team3189.robot.commands.ClawToggle;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;
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
	// private JoystickButton leftThree = new JoystickButton(leftjoystick, 3);
	// private JoystickButton leftFour = new JoystickButton(leftjoystick, 4);
	// private JoystickButton leftFive = new JoystickButton(leftjoystick, 5);
	// private JoystickButton leftSix = new JoystickButton(leftjoystick, 6);
	// private JoystickButton leftSeven = new JoystickButton(leftjoystick, 7);
	// private JoystickButton leftEight = new JoystickButton(leftjoystick, 8);
	// private JoystickButton leftNine = new JoystickButton(leftjoystick, 9);
	// private JoystickButton leftTen = new JoystickButton(leftjoystick, 10);
	// private JoystickButton rightFour = new JoystickButton(rightjoystick, 4);
	// private JoystickButton rightFive = new JoystickButton(rightjoystick, 5);
	// private JoystickButton rightThree = new JoystickButton(rightjoystick, 3);
	// private JoystickButton rightOne = new JoystickButton(rightjoystick, 1);
	public JoystickButton rightTen = new JoystickButton(rightjoystick, 10);
	public JoystickButton coSix = new JoystickButton(grabjoystick, 6);
	public JoystickButton coSeven = new JoystickButton(grabjoystick, 7);
	public JoystickButton coOnedyOne = new JoystickButton(grabjoystick, 11);
	public JoystickButton coTen = new JoystickButton(grabjoystick, 10);
	public JoystickButton coTwo = new JoystickButton(grabjoystick, 2);
	public JoystickButton coEight = new JoystickButton(grabjoystick, 8);
	public JoystickButton coNine = new JoystickButton(grabjoystick, 9);
	public JoystickButton coThree = new JoystickButton(grabjoystick, 3);

	public OI() {
		leftOne.whileHeld(new GearboxHigh());// Hold the left trigger to be in
		coTwo.whileHeld(new DropperOpen());
		coThree.whenPressed(new DropperToggle());
		coSix.whileHeld(new WinchLift());
		coSeven.whileHeld(new WinchLower());
		coOnedyOne.whenPressed(new ClawGoToHigh());
		coTen.whenPressed(new ClawGoToMid());
		coNine.whenPressed(new ClawGoToLow());
		coEight.whenPressed(new ClawToggle());
		rightTen.whileHeld(new ClawControl());
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