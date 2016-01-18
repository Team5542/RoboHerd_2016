package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class UserCamera extends CommandBase {
	
	OI oi = new OI();
	Joystick stick = oi.getStick();
	
    public UserCamera() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int dpad = stick.getPOV(OI.pov);
    	if (dpad == 0 || dpad == 45 || dpad == 315){
    		camera.tiltUp();
    	}
    	if (dpad == 90 || dpad == 45 || dpad == 135){
    		camera.panRight();
    	}
    	if (dpad == 180 || dpad == 135 || dpad == 225){
    		camera.tiltDown();
    	}
    	if (dpad == 270 || dpad == 225 || dpad == 315){
    		camera.panLeft();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
