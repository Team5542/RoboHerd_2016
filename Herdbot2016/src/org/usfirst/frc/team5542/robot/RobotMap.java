package org.usfirst.frc.team5542.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Driver motors, with l=left, r=right, f=front, b=back
    
	public static int lfMotor = 3;
    public static int rfMotor = 1;
    public static int lbMotor = 4;
    public static int rbMotor = 2;
	
    //gyro
    public static int gyro = 1;
    
    //encoder
    public static int enc1 = 2;
    public static int enc2 = 3;
    
    // Throwing motors
    public static int ltMotor = 5;
    public static int rtMotor = 6;
    
    //camera 1 motors
    public static int panServo = 1;
    public static int tiltServo = 2;
    
    //camera 2 motors
    public static int panServo2 = 3;
    public static int tiltservo2 = 4;
    
    //Lift motors
    public static int liftMotor = 7;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
