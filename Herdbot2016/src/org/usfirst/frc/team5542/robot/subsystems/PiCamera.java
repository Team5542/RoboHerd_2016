package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PiCamera extends Subsystem {
	public static PiCamera instance;
	
	CANTalon liftMotor;
	
	private PiCamera(){
	liftMotor = new CANTalon(RobotMap.liftMotor);
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
    	liftMotor.set(-0.02);
    }
    public void stop(){
    	liftMotor.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

