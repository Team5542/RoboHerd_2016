package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	double z = -xbox.getRawAxis(OI.lxAxis);
    	
    	if(y < 0.10 && y > -0.10){
    		y = 0;
    	} 
    	if(z < 0.10 && z > -0.10){
    		z = 0;
    	}
    	SmartDashboard.putNumber("Move Value", y);
    	SmartDashboard.putNumber("Turn Value", z);
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
    	drivetrain.fprDrive(0, 0);
    }
}
