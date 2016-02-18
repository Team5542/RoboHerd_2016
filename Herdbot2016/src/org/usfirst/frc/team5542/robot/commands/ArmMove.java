package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick stick = Robot.oi.getStick();
    	
    	// Manual Logic loop
//    	if (OI.armlogic == 0){
    	double move = stick.getRawAxis(OI.stickY);
	    if(move < -0.35){
	    		arm.moveDown();
	    }
	    if(move > 0.35){
	    		arm.moveUp();
	    }
	    if(0.35 >= move && move >= -.35){
	    		arm.stopActuate();
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
    	arm.intake(0);
    	arm.stopActuate();
    }
}
