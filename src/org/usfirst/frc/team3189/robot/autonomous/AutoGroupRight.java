package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.commands.AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide;
import org.usfirst.frc.team3189.robot.commands.DropperClose;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Drives the robot forward for 1/2 second, turns the robot 45 degrees, and
 * stops the robot using sonar
 * 
 * @author Damon Wagenknecht
 *
 */
public class AutoGroupRight extends CommandGroup {

	public AutoGroupRight() {
		Robot.drivetrain.resetDistance();
		addSequential(new AutoDrivetrainEncoder(65));
		Robot.drivetrain.resetGyro();
		addSequential(new AutoVisionDrive());
		addSequential(new AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(Constants.AUTO_STOP_DISTANCE));
		addSequential(new WaitCommand(0.35));
		addParallel(new DropperOpen());
		addSequential(new WaitCommand(0.5));
		addSequential(new AutoDrivetrainReverse(2.5));
		addSequential(new DropperClose());
	}
}
