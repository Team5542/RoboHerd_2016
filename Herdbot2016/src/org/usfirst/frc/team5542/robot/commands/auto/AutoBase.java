package org.usfirst.frc.team5542.robot.commands.auto;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public abstract class AutoBase extends CommandBase {

	static MoveArm moveArm = new MoveArm();
	public static void initAutoRock(){
		MoveForwardRock move = new MoveForwardRock();
		move.start();
		Timer.delay(3.5);
		moveArm.start();
	}

	public static void initAutoLow() {
		moveArm.start();
		Timer.delay(1);
		MoveForwardLow move = new MoveForwardLow();
		move.start();
	}
	
	public static void initAutoMoat(){
		MoveForwardMoat move = new MoveForwardMoat();
		move.start();
	}
}
