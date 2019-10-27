import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;

public class DateTimeTwo {
	// Private variable initialization.
	private LinkedHashMap <LocalDate, Integer> dates = new LinkedHashMap <LocalDate, Integer>();
	private LinkedHashMap <Integer, String> intToDay = new LinkedHashMap <Integer, String>();

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
}
