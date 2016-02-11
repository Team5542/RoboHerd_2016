package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Gyro extends PIDSubsystem {

	CANTalon motor = new CANTalon (RobotMap.liftMotor);
	Gyro gyro;
    // Initialize your subsystem here
    public Gyro() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Gyro",0,0,0);
    	disable();
    }
    
    public static Gyro instance;
	
    public static Gyro getInstance(){
    	if (instance == null)
    		instance = new Gyro();
    	return instance;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
    	motor.pidWrite(output);
    }
}
