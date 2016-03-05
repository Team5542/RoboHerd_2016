package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.ArmMove;



//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Manual extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon ltMotor, rtMotor, aMotor;
	private Solenoid solenoid;
	double encoderPos;
	public DigitalInput limitSwitch;
	
	//private Gyro gyro;
	
	private Manual(){
		ltMotor = new CANTalon(RobotMap.ltMotor);
		rtMotor = new CANTalon(RobotMap.rtMotor);
		aMotor = new CANTalon(RobotMap.liftMotor);
		solenoid = new Solenoid(RobotMap.solenoid);
		encoderPos = aMotor.get();
		//gyro = new AnalogGyro(RobotMap.gyro);
		limitSwitch  = new DigitalInput(RobotMap.limit);
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
		if(move >= 0){
		solenoid.set(false);
		} else {
			Timer.delay(.7);
			solenoid.set(true);
		}
		SmartDashboard.putBoolean("Motivator", solenoid.get());
		
	}
	
	public void switchMotivator(){
		solenoid.set(!solenoid.get());
	}
	
	public void move(double value){
		
		//if(encoderPos <= 50 && encoderPos >= -10){
			aMotor.set(value);
		//}
		//SmartDashboard.putNumber("Encoder possition", encoderPos);
		//SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}
	public void stopActuate(){
		//if(SmartDashboard.getNumber("Gyro") > gyro.getAngle()){
			//aMotor.set(0.25);
		//} else {
			aMotor.set(0);
		}
	//}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ArmMove());
    }
}

