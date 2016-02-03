package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.FprDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive myDrive;
	private CANTalon lfMotor, rfMotor, lbMotor, rbMotor;

	private DriveTrain(){
		lfMotor = new CANTalon(RobotMap.lfMotor);
		rfMotor = new CANTalon(RobotMap.rfMotor);
		lbMotor = new CANTalon(RobotMap.lbMotor);
		rbMotor = new CANTalon(RobotMap.rbMotor);
		myDrive = new RobotDrive(lfMotor, lbMotor, rfMotor, rbMotor);
	}
	
	public static DriveTrain instance;
	
	public static DriveTrain getInstance(){
		if (instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public void tankDrive(double left, double right){
		myDrive.tankDrive(left, right);
	}
	
	public void fprDrive(double move, double turn){
		myDrive.arcadeDrive(move, turn);
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new FprDrive());
    }
}

