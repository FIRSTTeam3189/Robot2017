package org.usfirst.frc.team3189.robot.autonomous;

import org.usfirst.frc.team3189.robot.Constants;
import org.usfirst.frc.team3189.robot.Robot;
import org.usfirst.frc.team3189.robot.commands.AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide;
import org.usfirst.frc.team3189.robot.commands.DropperClose;
import org.usfirst.frc.team3189.robot.commands.DropperOpen;
import org.usfirst.frc.team3189.robot.commands.WinchUnHook;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Drives the robot foward until 1/2 seconds, turns the robot 45 degrees, and
 * stops the robot
 * 
 * @author Damon Wagenknecht
 *
 */
public class AutoGroupLeft extends CommandGroup {

	public AutoGroupLeft() {
		Robot.drivetrain.resetDistance();
		addSequential(new AutoDrivetrainEncoder(65));
		addSequential(new AutoDrivetrainEncoderTurn(8));
		addSequential(new AutoDrivetrainSonarToGoPleaseWithExtraVisionOnTheSide(Constants.AUTO_STOP_DISTANCE));
		addSequential(new WaitCommand(0.35));
		addParallel(new DropperOpen());
		addSequential(new WaitCommand(0.5));
		addParallel(new WinchUnHook());
		addSequential(new AutoDrivetrainReverse(2.5));
		addSequential(new DropperClose());
	}
}
