package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class ArmMove extends CommandBase {
	
    public ArmMove() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//encoder.setDistancePerPulse(0.0383);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick stick = Robot.oi.getStick();
    	double move = -stick.getRawAxis(OI.stickY);
	    
    	if(move <= 0.10 && move >= -.10){
	    	move = 0;
	    }

    	//Use this to activate limit switch functionality. Ask Chris
    	//about setting up the limit switch for high/low and stuff. 
    	
	    /*if (arm.limitSwitch.get() && (move > 0)){
	    	move = 0;
	    }
	    */
    	else{
	    	arm.move(Math.abs(move) * move);
	    }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	arm.stopActuate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	arm.stopActuate();
    }
}