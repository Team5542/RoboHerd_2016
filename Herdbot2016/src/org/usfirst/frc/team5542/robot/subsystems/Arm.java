package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private RobotDrive liftDrive, intakeDrive;
	private CANTalon ltMotor, rtMotor;
	
	private Arm(){
		ltMotor = new CANTalon(RobotMap.ltMotor);
		rtMotor = new CANTalon(RobotMap.rtMotor);
	}
	
	public static Arm instance;
	
	public static Arm getInstance(){
		if (instance == null)
			instance = new Arm();
		return instance;
	}
	
	public void moveArm(double move, double turn){
		liftDrive.arcadeDrive(move, turn);
	}
	
	public void intake(double move, double turn){
		intakeDrive.arcadeDrive(move, turn);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

