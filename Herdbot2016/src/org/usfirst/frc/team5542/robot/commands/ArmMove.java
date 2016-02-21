package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmMove extends CommandBase {
	
	Encoder encoder;
	
    public ArmMove() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
        //requires(motorencoder);
        //encoder = new Encoder(RobotMap.enc1, RobotMap.enc2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//encoder.setDistancePerPulse(0.0383);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick stick = Robot.oi.getStick();
    	PowerDistributionPanel pdp = new PowerDistributionPanel();
    	SmartDashboard.putNumber("Motor current", pdp.getCurrent(12));
    	
    	double move = -stick.getRawAxis(OI.stickY);
	    if(0.10 >= move && move >= -.10){
    		//arm.stopActuate();
	    	motorencoder.setSetpoint(motorencoder.getPosition());
	    	motorencoder.enable();
	    }
	    else{
	    	arm.move(move*move*move);
	    	motorencoder.disable();
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