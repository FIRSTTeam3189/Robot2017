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

	public Piston(int extend, int retract) {
		/**
		 * Calls the other piston constructor
		 */
		this(extend, retract, true);
	}

	public Piston(int extend, int retract, boolean isReracted) {
		/**
		 * Creates the piston objects
		 */
		this.extend = new Solenoid(extend);
		this.retract = new Solenoid(retract);
		this.extend.set(!isReracted);
		this.retract.set(isReracted);
	}

	public void extend() {
		/**
		 * Extends the piston
		 */
		extend.set(true);
		retract.set(false);
	}

	public void retract() {
		/**
		 * Retracts the piston
		 */
		extend.set(false);
		retract.set(true);
	}

	public void toggle() {
		/**
		 * Toggles the piston
		 */
		extend.set(!extend.get());
		retract.set(!retract.get());
	}
}