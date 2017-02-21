package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

//TODO java doc this
/**
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
