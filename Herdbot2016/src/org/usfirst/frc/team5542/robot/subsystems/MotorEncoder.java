package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class MotorEncoder extends PIDSubsystem {

	CANTalon motor = new CANTalon (RobotMap.liftMotor);
	public Encoder motorEncoder = new Encoder(0, 0, false);
	
    // Initialize your subsystem here
    public MotorEncoder() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Encoder",0,0,0);
    	disable();
    }
    
    public static MotorEncoder instance;
    
    public static MotorEncoder getInstance(){
    	if (instance == null)
    		instance = new MotorEncoder();
    	return instance;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Sets pid goal to travel for going under objects
    // !!! NEED TO RESET EACH TIME ROBOT IS INIT !!!
    public void lowTravel(){
    	this.setSetpoint(0);
    }
    
    // Sets pid goal to travel for going over objects
    // !!! NEED TO DETERMINE THIS VALUE !!!
    public void highTravel(){
    	this.setSetpoint(25);
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
