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
	protected static Manual arm;
	protected static PiCamera pi;
	protected static MotorEncoder motorencoder;
	protected static Gyro gyro;
	protected static SolenoidControl solenoid;
	
	public static void init(){
		solenoid = SolenoidControl.getInstace();
		//camera = Camera.getInstance();
		drivetrain = DriveTrain.getInstance();
		arm = Manual.getInstance();
		//pi = PiCamera.getInstance();
		motorencoder = MotorEncoder.getInstance();
		gyro = Gyro.getInstance();
	}
}