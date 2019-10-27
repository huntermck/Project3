
public class MesoAsciiCal extends MesoAsciiAbstract {
	// Variables.
	private MesoStation station;

	// Returns current class instance variables.
	public MesoAsciiCal(MesoStation station) {
		this.station = station;
	}

	@Override
	int calAverage() {
		// Variables.
		double total = 0;

		// Loop that retrieves station ID from txt.
		for (int i = 0; i < station.getStID().length(); i++) {
			total += station.getStID().charAt(i);
		}

		double floor = Math.floor(total / station.getStID().length());
		double ceil = Math.ceil(total / station.getStID().length());

		if (floor / ceil - Math.floor(floor / ceil) < .25) {
			return (int) floor;
		} else if (floor / ceil - Math.floor(floor / ceil) >= .25) {
			return (int) ceil;
		}

		return -1;
	}

}