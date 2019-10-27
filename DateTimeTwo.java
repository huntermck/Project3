import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateTimeTwo {
	// Private variable initialization.
	private LinkedHashMap<LocalDate, Integer> dates = new LinkedHashMap<LocalDate, Integer>();
	private LinkedHashMap<Integer, String> intToDay = new LinkedHashMap<Integer, String>();

	// TODO Description for constructor.
	public DateTimeTwo() throws IOException {
		intToDay.put(1, "SUNDAY");

		intToDay.put(2, "MONDAY");

		intToDay.put(3, "TUESDAY");

		intToDay.put(4, "WEDNESDAY");

		intToDay.put(5, "THURSDAY");

		intToDay.put(6, "FRIDAY");

		intToDay.put(7, "SATURDAY");

		loadDates();
	}

	// TODO Constructor description.
	private void loadDates() {
		// Reads in dates.txt file.
		BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\hunte\\eclipse-workspace\\Project3\\src\\Dates.txt"));

		// TODO Description.
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M.dd.yyyy");

		// TODO Description of String and i variable. And while loop.
		String line = reader.readLine();
		int i = 1;
		while (line != null) {
			dates.put(LocalDate.parse(line, dateFormat), i);
			line = reader.readLine();
			++i;
		}

		reader.close();
	}

	// TODO Description.
	public void daysOfCurrentMonth() {
		Calendar now = Calendar.getInstance();

		// TODO Description of gregCal 10.
		Calendar tenthDay = new GregorianCalendar();
		tenthDay.set(now.YEAR, now.MONTH, 10);

		// TODO Description of gregCal 18.
		Calendar eighteenthDay = new GregorianCalendar();
		eighteenthDay.set(now.YEAR, now.MONTH, 18);
	}

	// TODO Description of constructor.
	public void dateHashMap() {
		// TODO Description of for loop.
		for (Map.Entry<LocalDate, Integer> entry : dates.entrySet()) {
			System.out.println(entry.getKey().toString() + ":" + entry.getValue());
		}
	}

	// TODO Description of constructor.
	public void dateHashMapSorted() {
		ArrayList<LocalDate> sortedDates = new ArrayList<LocalDate>();
		LocalDate lowest = LocalDate.now();

		// TODO For loop description.
		for (Map.Entry<LocalDate, Integer> entry : dates.entrySet()) {
			sortedDates.add(entry.getKey());
		}

		// TODO For loop description.
		for (int i = 0; i < sortedDates.size(); i++) {
			for (int j = i + 1; j < sortedDates.size(); j++) {
				if (sortedDates.get(i).getYear() > sortedDates.get(j).getYear()) {
					LocalDate temp = sortedDates.get(i);
					sortedDates.set(i, sortedDates.get(j));
					sortedDates.set(j, temp);
				}
			}
		}

		// TODO For loop description.
		for (int i = 0; i < sortedDates.size(); i++) {
			System.out.println(sortedDates.get(i).toString() + ":" + dates.get(sortedDates.get(i)));
		}

	}

}
