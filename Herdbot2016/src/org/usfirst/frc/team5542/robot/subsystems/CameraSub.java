package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSub extends Subsystem {
    
    public void refreshCamera(){
    	Robot robot = new Robot();
    	robot.updateCamera();
    	Timer.delay(.5);
    }
    
    static CameraSub instance;
    
    public static CameraSub getInstance(){
    	if(instance == null){
    		instance = new CameraSub();
    	}
    	return instance;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

