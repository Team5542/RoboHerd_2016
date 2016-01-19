package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserCamera;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    public static Camera instance;
    
    private Servo tiltMotor;
    private Servo panMotor;
    private double component = 0.01;
    
    public Camera(){
    	tiltMotor = new Servo(RobotMap.tiltServo);
    	panMotor = new Servo(RobotMap.panServo);
    }
    
    public static Camera getInstance(){
    	if(instance == null){
    		instance = new Camera();
    	}
    	return instance;
    }
    
    public void tiltUp(){
    	double tilt = tiltMotor.get();
    	tilt = tilt + component;
    	tiltMotor.set(tilt);
    }
    public void tiltDown(){
    	double tilt = tiltMotor.get();
    	tilt = tilt - component;
    	tiltMotor.set(tilt);
    }
    public void panRight(){
    	double pan = panMotor.get();
    	pan = pan + component;
    	panMotor.set(pan);
    }
    public void panLeft(){
    	double pan = panMotor.get();
    	pan = pan - component;
    	panMotor.set(pan);
    }
    public void CenterCamera(double pan, double tilt){
    	panMotor.set(pan);
    	tiltMotor.set(tilt);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new UserCamera());
    }
}

