import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MesoLexicographical extends MesoSortedAbstract
{
	// Creates HashMap.
	private HashMap <String, Integer> asciiVal;
	
	// Returns class instance variables.
	public MesoLexicographical(HashMap <String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		
		// Creates Map.
		Map <String, Integer> sorted = sortedMap(asciiVal);
		
		//TODO Description.
		for(Map.Entry <String, Integer> entry : sorted.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
	
	@Override
	public Map <String, Integer> sortedMap(HashMap <String, Integer> unsorted) {
		ArrayList<String> sortedStations = new ArrayList<String>();
		return unsorted;
	}
}