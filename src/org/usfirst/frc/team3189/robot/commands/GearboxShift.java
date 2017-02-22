package org.usfirst.frc.team3189.robot.commands;

import org.usfirst.frc.team3189.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//TODO java doc this
/** Shifts the Gearbox
 * @author Nate Mansfield
 */
public class GearboxShift extends Command {

	public GearboxShift() {
		requires(Robot.gearbox);
	}

	protected void initialize() {
		Robot.gearbox.toggle();

	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
