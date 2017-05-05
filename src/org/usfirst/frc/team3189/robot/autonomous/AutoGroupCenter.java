package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.commands.AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide;
import org.usfirst.frc.team3189.robot.commands.DropperClose;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;
import org.usfirst.frc.team3189.robot.commands.WinchUnHook;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Drives forward with sonar and drops the gear
 * 
 * @author Damon Wagenknecht
 *
 */
public class AutoGroupCenter extends CommandGroup {

	public AutoGroupCenter() {
		//addSequential(new AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(Constants.AUTO_STOP_DISTANCE));
		addSequential(new AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(Constants.AUTO_STOP_DISTANCE + 1));
		addSequential(new WaitCommand(0.35));
		addParallel(new DropperOpen());
		addSequential(new WaitCommand(0.5));
		addParallel(new WinchUnHook());
		addSequential(new AutoDrivetrainReverse(2.5));
		addSequential(new DropperClose());
	}
}
