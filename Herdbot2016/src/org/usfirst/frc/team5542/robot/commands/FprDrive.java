package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class FprDrive extends CommandBase {

    public FprDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	OI oi = new OI();
    	Joystick stick = oi.getStick();
    	double y = -stick.getRawAxis(OI.stickY);
    	double z = stick.getRawAxis(OI.stickZ);
    	double slider = stick.getRawAxis(OI.slider);
    	double sensitivity = slider + 1;
    	if(y < 0.05 && y > -0.05){
    		y = 0;
    	} else {
    		y = Math.pow(y, sensitivity);
    	}
    	if(z < 0.05 && z > -0.05){
    		z = 0;
    	} else {
    		z = Math.pow(z, sensitivity);
    	}
    	drivetrain.fprDrive(y, z);
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
