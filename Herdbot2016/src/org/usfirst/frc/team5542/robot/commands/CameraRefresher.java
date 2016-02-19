package org.usfirst.frc.team5542.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class CameraRefresher extends CommandBase {

    public CameraRefresher() {
        requires(cameraR);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cameraR.refreshCamera();
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
