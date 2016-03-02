package org.usfirst.frc.team5542.robot.commands.auto;


/**
 *
 */
public class MoveForward extends AutoBase {

    public MoveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(.5, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return moveOff;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
