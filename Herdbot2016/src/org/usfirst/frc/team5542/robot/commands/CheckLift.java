package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CheckLift extends CommandBase {

    public CheckLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (arm);
    	requires (motorencoder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Joystick stick = Robot.oi.getStick();
    	double move = -stick.getRawAxis(OI.stickY);
	    if(move <= 0.10 && move >= -0.10){
	    	motorencoder.setSetpoint(motorencoder.getPosition());
	    	motorencoder.enable();
	    }
	    else{
	    	motorencoder.disable();
	    }
    	//PowerDistributionPanel pdp = new PowerDistributionPanel();
    	//SmartDashboard.putNumber("Motor current", pdp.getCurrent(12));
    	SmartDashboard.putNumber("Encoder position", motorencoder.getPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
