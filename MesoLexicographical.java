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
	}
}