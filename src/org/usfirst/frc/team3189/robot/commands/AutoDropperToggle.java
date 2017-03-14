package org.usfirst.frc.team3189.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDropperToggle extends CommandGroup {

	public AutoDropperToggle() {
		addSequential(new ClawGoToHigh());
		addSequential(new DropperToggle());
	}
}
