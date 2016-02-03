package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Base class to allow for direct subsystem reference in Commands and more organization in Robot.
 *I'm told this is a good idea...
 */
public abstract class CommandBase extends Command {

	protected static DriveTrain drivetrain;
	protected static Camera camera;
	protected static Arm arm;
	protected static PiCamera pi;
	
	public static void init(){
		//camera = Camera.getInstance();
		drivetrain = DriveTrain.getInstance();
		arm = Arm.getInstance();
		//pi = PiCamera.getInstance();
	}
}