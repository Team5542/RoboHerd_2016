package org.usfirst.frc.team5542.robot.commands.auto;


/**
 *
 */
public class MoveForwardRock extends AutoBase {
	
    long startTime;
    long time = 3000;//in ms the time we move for
	
	public MoveForwardRock() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((System.currentTimeMillis() - startTime) >= time);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
