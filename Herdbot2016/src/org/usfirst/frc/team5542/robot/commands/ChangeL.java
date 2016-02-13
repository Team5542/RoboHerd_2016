package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;

/**
 *
 */
public class ChangeL extends CommandBase {

    public ChangeL(int input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	OI.armlogic = input;
    	if (input == 0){
    		motorencoder.disable();
    		gyro.disable();
    	}
    	if (input == 1){
    		motorencoder.disable();
    		//gyro.enable();
    	}
    	if (input == 2 || input == 3){
    		motorencoder.enable();
    		gyro.disable();
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
