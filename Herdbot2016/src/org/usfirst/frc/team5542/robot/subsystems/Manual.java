package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.ArmFeedShootMove;



//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.interfaces.Gyro;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Manual extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon ltMotor, rtMotor, aMotor;
	
	
	//private Gyro gyro;
	
	private Manual(){
		ltMotor = new CANTalon(RobotMap.ltMotor);
		rtMotor = new CANTalon(RobotMap.rtMotor);
		aMotor = new CANTalon(RobotMap.liftMotor);
		//gyro = new AnalogGyro(RobotMap.gyro);
	}
	
	public static Manual instance;
	
	public static Manual getInstance(){
		if (instance == null)
			instance = new Manual();
		return instance;
	}
	
	
	public void intake(double move){
		ltMotor.set(move);
		rtMotor.set(-move);
	}
	public void moveUp(){
		aMotor.set(0.5);
		//SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}
	public void moveDown(){
		aMotor.set(-0.5);
		//SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}
	public void stop(){
		//if(SmartDashboard.getNumber("Gyro") > gyro.getAngle()){
			//aMotor.set(0.25);
		//} else {
			aMotor.set(0);
		}
	//}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ArmFeedShootMove());
    }
}

