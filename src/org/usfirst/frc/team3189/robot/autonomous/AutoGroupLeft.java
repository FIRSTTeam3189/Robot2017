package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives the robot foward until 1/2 seconds, turns the robot 45 degrees, and stops the robot
 * @author Damon Wagenknecht
 *
 */
public class AutoGroupLeft extends CommandGroup {

	public AutoGroupLeft() {
		addSequential(new AutoDrivetrainForward(0.5));
		addSequential(new AutoDrivetrainGyroTurn(45.0));
		// TODO: Add vision correction
		addSequential(new AutoDrivetrainSonarGoto(Constants.AUTO_STOP_DISTANCE));
	}
}
