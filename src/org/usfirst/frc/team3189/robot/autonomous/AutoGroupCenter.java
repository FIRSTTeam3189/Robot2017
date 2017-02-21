package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.commands.DropperClose;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;
import edu.wpi.first.wpilibj.command.CommandGroup;

//TODO java doc this
/**
 *
 */
public class AutoGroupCenter extends CommandGroup {

	public AutoGroupCenter() {
		addSequential(new AutoDrivetrainSonarGoto(Constants.AUTO_STOP_DISTANCE));
		addSequential(new DropperOpen());
		addSequential(new DropperClose());
	}
}
