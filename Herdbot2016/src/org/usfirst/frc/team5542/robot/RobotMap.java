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
	
    // Throwing motors
    public static int ltMotor = 5;
    public static int rtMotor = 6;
    
    //camera motors
    public static int panServo = 7;
    public static int tiltServo = 8;
    
    //Lift motors
    public static int liftMotor = 9;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
