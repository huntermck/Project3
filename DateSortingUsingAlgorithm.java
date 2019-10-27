import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class DateSortingUsingAlgorithm {
	// Private variables initilization.
	private LinkedHashMap <LocalDate, Integer> stations = new LinkedHashMap <LocalDate, Integer>();

	//TODO Description.
	public DateSortingUsingAlgorithm() throws IOException {

	}

	//TODO Description.
	private void loadStations() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\hunte\\eclipse-workspace\\Project3\\src\\SortingDates.txt"));
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-dd");
	}
	
}
