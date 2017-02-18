package org.usfirst.frc.team3189.robot;

import org.usfirst.frc.team3189.robot.autonomous.StartAutoCenter;
import org.usfirst.frc.team3189.robot.autonomous.StartAutoLeft;
import org.usfirst.frc.team3189.robot.autonomous.StartAutoRight;
import org.usfirst.frc.team3189.robot.commands.CloseClaw;
import org.usfirst.frc.team3189.robot.commands.CloseDropper;
import org.usfirst.frc.team3189.robot.commands.ControlWinch;
import org.usfirst.frc.team3189.robot.commands.LiftClaw;
import org.usfirst.frc.team3189.robot.commands.LowerClaw;
import org.usfirst.frc.team3189.robot.commands.OpenClaw;
import org.usfirst.frc.team3189.robot.commands.OpenDropper;
import org.usfirst.frc.team3189.robot.commands.ShiftDown;
import org.usfirst.frc.team3189.robot.commands.ShiftGears;
import org.usfirst.frc.team3189.robot.commands.ShiftUp;
import org.usfirst.frc.team3189.robot.commands.ToggleDropper;

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
	private JoystickButton openDropper = new JoystickButton(leftjoystick, 5);
	private JoystickButton closeDropper = new JoystickButton(leftjoystick, 6);
	private JoystickButton liftClaw = new JoystickButton(leftjoystick, 7);
	private JoystickButton lowerClaw = new JoystickButton(leftjoystick, 8);
	private JoystickButton openClaw = new JoystickButton(leftjoystick, 9);
	private JoystickButton closeClaw = new JoystickButton(leftjoystick, 10);
	private JoystickButton turnLeft = new JoystickButton(rightjoystick, 4);
	private JoystickButton turnRight = new JoystickButton(rightjoystick, 5);
	private JoystickButton goFoward = new JoystickButton(rightjoystick, 3);

	public OI() {
		//shiftDown.whenPressed(new ShiftDown());
		//shiftUp.whenPressed(new ShiftUp());
		shiftGears.whileHeld(new ShiftUp());
		shiftUp.whenPressed(new ToggleDropper());
		//openDropper.whenPressed(new OpenDropper());
		//closeDropper.whenPressed(new CloseDropper());
		//liftClaw.whenPressed(new LiftClaw());
		//lowerClaw.whenPressed(new LowerClaw());
		//closeClaw.whenPressed(new CloseClaw());
		//openClaw.whenPressed(new OpenClaw());
		//turnLeft.whenPressed(new StartAutoLeft());
		//turnRight.whenPressed(new StartAutoRight());
		//goFoward.whenPressed(new StartAutoCenter());
		
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
	 * @return Double copilot's joystick value
	 */
	public double getCoPilotJoystickY(){
		return grabjoystick.getY();
	}
}