package org.usfirst.frc.team3189.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3189.robot.autonomous.AutoGroupCenter;
import org.usfirst.frc.team3189.robot.autonomous.AutoGroupLeft;
import org.usfirst.frc.team3189.robot.autonomous.AutoGroupRight;
import org.usfirst.frc.team3189.robot.commands.AutoGroupNothing;
import org.usfirst.frc.team3189.robot.subsystems.Claw;
import org.usfirst.frc.team3189.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3189.robot.subsystems.Dropper;
import org.usfirst.frc.team3189.robot.subsystems.Gearbox;
import org.usfirst.frc.team3189.robot.subsystems.Vision;
import org.usfirst.frc.team3189.robot.subsystems.Winch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Gearbox gearbox;
	public static Winch winch;
	public static Dropper dropper;
	public static Claw claw;
	public static Vision vision;
	
	public static UsbCamera cam1;
	public static UsbCamera cam2;
	public static VideoSink server;
	
	public static long timeThing;
	public static boolean thing = false;
	Compressor comp = new Compressor(0); // is this a magic number? -Nate
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		comp.setClosedLoopControl(true);
		drivetrain = new Drivetrain();
		gearbox = new Gearbox();
		winch = new Winch();
		dropper = new Dropper();
		claw = new Claw();
		vision = new Vision();
		oi = new OI();
		try {
			cam1 = CameraServer.getInstance().startAutomaticCapture(0);
			if (Configamabob.HAS_TWO_CAMERAS) {
				cam2 = CameraServer.getInstance().startAutomaticCapture(1);
			}
			server = CameraServer.getInstance().getServer();
			if (Configamabob.HAS_TWO_CAMERAS && Configamabob.LOW_CAM_IS_ONE) {
				server.setSource(cam1);
			} else {
				server.setSource(cam2);
			}
		} catch (Exception e) {
			System.out.println("Camera Error");
		}
		chooser.addDefault("Center", new AutoGroupCenter());
		chooser.addObject("Left", new AutoGroupLeft());
		chooser.addObject("Right", new AutoGroupRight());
		chooser.addObject("None", new AutoGroupNothing());
		SmartDashboard.putData("Auto mode", chooser);
		vision.start();
	}

	public static void useLowCamera() {
		if (Configamabob.HAS_TWO_CAMERAS) {
			if ((Configamabob.LOW_CAM_IS_ONE ? cam1 : cam2) != null) {
				server.setSource((Configamabob.LOW_CAM_IS_ONE ? cam1 : cam2));
			}
		}
	}

	public static void useHighCamera() {
		if (Configamabob.HAS_TWO_CAMERAS) {
			if ((Configamabob.LOW_CAM_IS_ONE ? cam2 : cam1) != null) {
				server.setSource((Configamabob.LOW_CAM_IS_ONE ? cam2 : cam1));
			}
		}
	}

	public void disabledInit() {
		if (Configamabob.HAS_TWO_CAMERAS && Configamabob.LOW_CAM_IS_ONE) {
			server.setSource(cam2);
		} else {
			server.setSource(cam1);
		}
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		updateStatus();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		updateStatus();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		updateStatus();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void updateStatus() {
		SmartDashboard.putData("drivetrain", drivetrain);
		SmartDashboard.putData("Claw", claw);
		drivetrain.updateStatus();
		claw.updateStatus();
		
		SmartDashboard.putNumber("CoPilot", oi.getCoPilotJoystickY());
		
		if (oi.rightTen.get()) {
			drivetrain.resetDistance();
		}
	}
}
