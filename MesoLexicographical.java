import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MesoLexicographical extends MesoSortedAbstract {
	// Creates HashMap.
	private HashMap<String, Integer> asciiVal;

	// Returns class instance variables.
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;

		// Creates Map.
		Map<String, Integer> sorted = sortedMap(asciiVal);

		// TODO Description.
		for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	// TODO Description of constructor.
	@Override
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		ArrayList<String> sortedStations = new ArrayList<String>();
		HashMap<String, Integer> sorted = new HashMap<String, Integer>();

		// TODO Description of for loop.
		for (Map.Entry<String, Integer> entry : unsorted.entrySet()) {
			sortedStations.add(entry.getKey());
		}

		// TODO Description of for loop.
		for (int i = 0; i < sortedStations.size(); i++) {
			for (int j = i + 1; j < sortedStations.size(); j++) {

				if ((int) sortedStations.get(i).charAt(0) < (int) sortedStations.get(j).charAt(0)) {
					String temp = sortedStations.get(i);
					sortedStations.set(i, sortedStations.get(j));
					sortedStations.set(j, temp);

				}
			}
		}
		
		for (int i = 0; i < sortedStations.size(); i++) {
			sorted.put(sortedStations.get(i), unsorted.get(sortedStations.get(i)));
		}
		
		return sorted;
		
	}
}
