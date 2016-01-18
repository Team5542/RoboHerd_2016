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
    	Joystick xbox = oi.getXbox();
    	double y = -xbox.getRawAxis(OI.lyAxis);
    	double z = xbox.getRawAxis(OI.lxAxis);
    	int sense = xbox.getPOV(OI.dPad);
    	int sensitivity = 1;
    	if (sense == 90){
    		if(sensitivity != 2){
    		sensitivity++;
    		}
    	}
    	if (sense == 270){
    		if(sensitivity != 1){
    		sensitivity--;
    		}
    	}
    	
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
