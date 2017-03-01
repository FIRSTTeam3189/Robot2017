package org.usfirst.frc.team3189.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogUltrasonic extends AnalogInput {

	/**
	 * a Ultrasonic sensor class that uses an analog port
	 * 
	 * @param channel
	 */
	public AnalogUltrasonic(int channel) {
		super(channel);
	}

	/**
	 * gets the voltage from the sensor and translates it to inches
	 * 
	 * @return distance in inches to object in front of the sensor
	 */
	public double getInches() {
		return this.getVoltage() * 44;
	}

}
