package org.usfirst.frc.team5542.robot.commands.auto;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public abstract class AutoBase extends CommandBase {
	
	public static void initAuto(){
		motorencoder.motorEncoder.reset();
		motorencoder.setSetpoint(280000);
		MoveForward move = new MoveForward();
		Timer.delay(4);
		move.start();
	}
}
