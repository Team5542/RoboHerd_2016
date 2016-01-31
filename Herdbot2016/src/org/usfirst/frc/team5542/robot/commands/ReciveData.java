package org.usfirst.frc.team5542.robot.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 */
public class ReciveData extends CommandBase {
	
	String serverAddress = "rhcpi.local";
	Socket s;
	BufferedReader s_in = null;
	
    public ReciveData() {
        requires(pi);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
			s = new Socket(serverAddress, 8000);
			s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String message;
        try {
			while ((message = s_in.readLine()) != null) 
			{
			   if(message.equalsIgnoreCase("up")){
				   pi.up();
			   } else if(message.equalsIgnoreCase("down")){
				   pi.down();
			   } else if(message.equalsIgnoreCase("sUp")){
				   pi.tiltUp();
			   } else if(message.equalsIgnoreCase("sDown")){
				   pi.tiltDown();
			   } else if(message.equalsIgnoreCase("sRight")){
				   pi.panRight();
			   } else if(message.equalsIgnoreCase("sLeft")){
				   pi.panLeft();
			   } else if(message.equalsIgnoreCase("shot")){
				   pi.fire();
			   } else {
				   pi.shot();
			   }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
