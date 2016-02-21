package org.usfirst.frc.team5542.robot.commands.auto;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public abstract class AutoBase extends CommandBase {
	
	protected static boolean calebrationOff = false;
	
	public static void initAuto(){
		Calebrate cal = new Calebrate();
		cal.start();
		Timer.delay(3);
		calebrationOff = false;
		Timer.delay(15);
		
	}
}
