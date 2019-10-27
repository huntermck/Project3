import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {

	// Variable initialization.
	private String id;
	HashMap <String, Integer> stations;
	ArrayList <String> stats;
	
	// Reads through the Mesonet file.
	public void read(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String data = br.readLine();
		
		br.readLine();
		br.readLine();
		
		while (data != null) {
			String cutID = data.trim();
			String newID = cutID.substring(0, 4);
			stats.add(newID);
			data = br.readLine();
		}
		
		br.close();
		
	}
	
	public MesoEquivalent(String stId) throws IOException{
		this.id = stId;
		stations = new HashMap<>();
		stats = new ArrayList<>();
		
		try {
			read("Mesonet.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Integer> calAsciiEqual() {
		MesoAsciiCal mesoCal = new MesoAsciiCal(new MesoStation(id));
		int asciiAverage = mesoCal.calAverage();
		
		// Desc.
		for (String station : stats) {
			MesoAsciiCal mesoCal2 = new MesoAsciiCal (new MesoStation(station));
			int asciiAverage2 = mesoCal2.calAverage();
			
			// Descr.
			if (asciiAverage2 == asciiAverage) {
				stations.put(station, mesoCal2);
			}
		}
		
		return stations;
		
	}
}
