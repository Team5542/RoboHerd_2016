package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends CommandBase {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick xbox = Robot.oi.getXbox();
    	double left = -xbox.getRawAxis(OI.lyAxis);
    	double right = -xbox.getRawAxis(OI.ryAxis);
    	int sense = xbox.getPOV(OI.dPad);
    	int sensitivity = 20;
    	if (sense == 90)
    		drivetrain.decSense(sensitivity);
    	if (sense == 270)
    		drivetrain.incSense(sensitivity);
    	if (left < 0.05 && left > -0.05)
    		left = 0;
    	if (right < 0.05 && left > -0.05)
    		right = 0;
    	left = left*left*20/sensitivity;
    	right = right*right*20/sensitivity;
    	drivetrain.tankDrive(left, right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.tankDrive(0, 0);
    }
}
