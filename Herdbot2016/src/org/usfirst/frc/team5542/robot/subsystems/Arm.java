package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.ArmFeedShootMove;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon ltMotor, rtMotor, aMotor;
	
	private Arm(){
		ltMotor = new CANTalon(RobotMap.ltMotor);
		rtMotor = new CANTalon(RobotMap.rtMotor);
		aMotor = new CANTalon(RobotMap.liftMotor);
	}
	
	public static Arm instance;
	
	public static Arm getInstance(){
		if (instance == null)
			instance = new Arm();
		return instance;
	}
	
	
	public void intake(double move){
		ltMotor.set(move);
		rtMotor.set(-move);
	}
	public void moveUp(){
		int pos = aMotor.getEncPosition();
		pos++;
		aMotor.setEncPosition(pos);
	}
	
	public void moveDown(){
		int pos = aMotor.getEncPosition();
		pos--;
		aMotor.setEncPosition(pos);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ArmFeedShootMove());
    }
}

