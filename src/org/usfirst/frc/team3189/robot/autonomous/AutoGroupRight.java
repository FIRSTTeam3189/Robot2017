package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives the robot forward for 1/2 second, turns the robot 45 degrees, and stops the robot using sonar
 * @author Damon Wagenknecht
 *
 */
public class AutoGroupRight extends CommandGroup {

	public AutoGroupRight() {
		addSequential(new AutoDrivetrainForward(0.5));
		addSequential(new AutoDrivetrainGyroTurn(-45.0));
		// TODO: Add vision correction.
		addSequential(new AutoDrivetrainSonarGoto(Constants.AUTO_STOP_DISTANCE));
	}
}
