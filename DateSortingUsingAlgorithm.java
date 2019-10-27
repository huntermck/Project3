import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateSortingUsingAlgorithm {
	// Private variables initilization.
	private LinkedHashMap<LocalDate, Integer> stations = new LinkedHashMap<LocalDate, Integer>();

	// TODO Description.
	public DateSortingUsingAlgorithm() throws IOException {
		loadStations();
	}

	// TODO Description.
	private void loadStations() throws IOException {
		// Creates BufferedReader and reads in File from SortingDates.txt.
		BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\hunte\\eclipse-workspace\\Project3\\src\\SortingDates.txt"));
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-dd");

		// Initializes variables and while loop parses values of file.
		String line = reader.readLine();
		int value = 0;
		while (line != null) {
			line = line.replaceAll(" ", "");
			line = line.replaceAll("\t", "");

			// increments value and allocates specific part of map with value.
			stations.put(LocalDate.parse(line, dateFormat), value);
			line = reader.readLine();
			++value;
		}

		reader.close();

	}

	// TODO Description of constructor.
	public void dateHashMapDescendingSorted() {
		// Creates ArrayList using time from LocalDate.
		ArrayList<LocalDate> timesSorted = new ArrayList<LocalDate>();

		// TODO Desc for for loop.
		for (Map.Entry<LocalDate, Integer> entry : stations.entrySet()) {
			timesSorted.add(entry.getKey());
		}

		// TODO Desc for for loop.
		for (int i = 0; i < timesSorted.size(); i++) {
			for (int j = i + 1; j < timesSorted.size(); j++) {
				if (timesSorted.get(i).getYear() > timesSorted.get(j).getYear()) {
					// Stores the values temporarily.
					LocalDate placeHolder = timesSorted.get(i);
					timesSorted.set(i, timesSorted.get(j));
					timesSorted.set(j, placeHolder);
				} else if (timesSorted.get(i).getYear() 
						== timesSorted.get(j).getYear()) {
					if (timesSorted.get(i).getMonthValue()
							> timesSorted.get(j).getMonthValue()) {
						
					}
				}
			}
		}

	}

}