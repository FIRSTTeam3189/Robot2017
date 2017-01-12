import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
	private Solenoid extend;
	private Solenoid retract;

	public Piston(int extend, int retract) {

	}

	public Piston(int extend, int retract, boolean isReracted) {
		this.extend = new Solenoid(extend);
		this.retract = new Solenoid(retract);
		this.extend.set(!isReracted);
		this.retract.set(isReracted);
	}

}
