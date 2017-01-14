package org.usfirst.frc.team3189.robot;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Created class to extend and retract pistons
 * 
 * @author Damon Wagenknecht
 *
 */
public class Piston {
	private Solenoid extend;
	private Solenoid retract;
	
	/**
	 * Calls the piston constructor.
	 * @param extend int port number for extension
	 * @param retract int port number for retraction
	 */
	public Piston(int extend, int retract) {
		
		this(extend, retract, true);
	}
	
/**
 * Creates a piston object.
 * @param extend int port number of extension
 * @param retract int port number of retraction
 * @param isReracted boolean whether to set the piston to retracted or not.
 */
	public Piston(int extend, int retract, boolean isReracted) {
		
		this.extend = new Solenoid(extend);
		this.retract = new Solenoid(retract);
		this.extend.set(!isReracted);
		this.retract.set(isReracted);
	}
	
	/**
	 * Extends the piston.
	 */
	public void extend() {
		extend.set(true);
		retract.set(false);
	}

	/**
	 * Retracts the piston
	 */
	public void retract() {
		
		extend.set(false);
		retract.set(true);
	}

	/**
	 * Toggles the piston
	 */
	public void toggle() {
		
		extend.set(!extend.get());
		retract.set(!retract.get());
	}
}