package org.usfirst.frc.team5542.robot.commands.auto;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public abstract class AutoBase extends CommandBase {
	
	protected static boolean calebrationOff = false;
	protected static boolean moveOff = false;
	
	public static void initAuto(){
		Calebrate cal = new Calebrate();
		MoveForward move = new MoveForward();
		cal.start();
		Timer.delay(3);
		calebrationOff = true;
		move.start();
		Timer.delay(12);
		moveOff = true;
	}
}
