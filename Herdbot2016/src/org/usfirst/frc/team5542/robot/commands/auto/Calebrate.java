package org.usfirst.frc.team5542.robot.commands.auto;

import edu.wpi.first.wpilibj.Encoder;
/**
 *
 */
public class Calebrate extends AutoBase {

    public Calebrate() {
        requires(arm);
        requires(motorencoder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	arm.move(.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return calebrationOff;
    }

    // Called once after isFinished returns true
    protected void end() {
    	motorencoder.motorEncoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	motorencoder.motorEncoder.reset();
    }
}
