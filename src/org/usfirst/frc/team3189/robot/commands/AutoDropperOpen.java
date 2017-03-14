package org.usfirst.frc.team3189.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDropperOpen extends CommandGroup {

	public AutoDropperOpen() {
		addSequential(new ClawGoToHigh());
		addSequential(new DropperOpen());
	}
}
