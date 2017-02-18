package org.usfirst.frc.team3189.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogUltrasonic extends AnalogInput{

	public AnalogUltrasonic(int channel) {
		super(channel);
	}
	
	public double getInches(){
		return this.getVoltage()*9.8;
	}
	
}
