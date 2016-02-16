package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class ArmFeedShootMove extends CommandBase {

    public ArmFeedShootMove() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick stick = Robot.oi.getStick();
    	
    	// Manual Logic loop
    	if (OI.armlogic == 0){
	    	double move = stick.getRawAxis(OI.stickY);
	    	if(move < -0.5){
	    		arm.moveDown();
	    	}
	    	if(move > 0.5){
	    		arm.moveUp();
	    	}
	    	if(0.5 >= move && move >= -.5){
	    		arm.stop();
	    	}
    	}    	
    	// Gyro/Camera Logic loop
    	if (OI.armlogic == 1){
    	}    	
    	// Travel low Logic loop
    	if (OI.armlogic == 2){
    		motorencoder.lowTravel();
    	}
    	// Travel high Logic loop
    	if (OI.armlogic == 3){
    		motorencoder.highTravel();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	arm.intake(0);
    	arm.stop();
    }
}
