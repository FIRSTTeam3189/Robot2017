package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

//TODO java doc this
/**
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
