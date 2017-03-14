package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.commands.DropperClose;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;
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
		addSequential(new AutoDrivetrainSonarGoto(Constants.AUTO_STOP_DISTANCE));
		addSequential(new WaitCommand(0.5));
		addParallel(new DropperOpen());
		addSequential(new WaitCommand(1));
		addSequential(new AutoDrivetrainReverse(2.5));
		addSequential(new DropperClose());
	}
}
