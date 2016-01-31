package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PiCamera extends Subsystem {
	public static PiCamera instance;
	
	private CANTalon ltMotor, rtMotor;
	
	private Servo panServo, tiltServo;
	
	double tilt;
	double pan;
	
	CANTalon liftMotor;
	
	private PiCamera(){
	liftMotor = new CANTalon(RobotMap.liftMotor);
	ltMotor = new CANTalon(RobotMap.ltMotor);
	rtMotor = new CANTalon(RobotMap.rtMotor);
	}
	
	public static PiCamera getInstance(){
		if (instance == null)
			instance = new PiCamera();
		return instance;
	}
    public void up(){
    	liftMotor.set(0.2);
    }
    public void down(){
    	liftMotor.set(-0.2);
    }
    public void tiltUp(){
    	tilt = tiltServo.getAngle();
    	tilt++;
    	tiltServo.setAngle(tilt);
    	SmartDashboard.putNumber("Tracking camera tilt angle", tilt);
    }
    public void tiltDown(){
    	tilt = tiltServo.getAngle();
    	tilt++;
    	tiltServo.set(tilt);
    	SmartDashboard.putNumber("Tracking camera tilt angle", tilt);
    }
    public void panRight(){
    	pan = panServo.getAngle();
    	pan++;
    	panServo.setAngle(pan);
    	SmartDashboard.putNumber("Tracking camera pan angle", pan);
    }
    public void panLeft(){
    	pan = panServo.getAngle();
    	pan--;
    	panServo.setAngle(pan);
    	SmartDashboard.putNumber("Tracking camera pan angle", pan);
    }
    public void stop(){
    	liftMotor.set(0);
    	ltMotor.set(0);
    	rtMotor.set(0);
    }
    public void shot(){
    	ltMotor.set(-1);
    	rtMotor.set(1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

