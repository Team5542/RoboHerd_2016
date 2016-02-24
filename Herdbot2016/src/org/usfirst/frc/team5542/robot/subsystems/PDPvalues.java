package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.commands.UpdatePDP;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PDPvalues extends Subsystem {
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    public void update(){
    	for(int i = 0; i <=24; i++){
    		String chanelName = "chanel" + i;
    		double current = pdp.getCurrent(i);
    		SmartDashboard.putNumber(chanelName, current);
    	}
    }
    protected static PDPvalues instance;
    public static PDPvalues getInstance(){
    	if(instance == null){
    		instance = new PDPvalues();
    	}
    	return instance;
    }
    public void initDefaultCommand() {
        setDefaultCommand(new UpdatePDP());
    }
}

