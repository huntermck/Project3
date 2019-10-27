import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeOne extends MesoDateTimeOneAbstract {
	// Constant variables.
	private static final int MILLIS_CONVERSION = 1000;

	@Override
	int getValueOfSecond() {
		// Fill this desc out.
		int seconds = (int) (System.currentTimeMillis() / MILLIS_CONVERSION);

		// Fill this desc out.
		return seconds % 60;
	}

	int converTime(int time) {
		return time + 24;
	}

	// TODO
	String currentTime() {
		String minutes = String.valueOf(getCurrentMinutes());
		
		// TODO
		if (getCurrentMinutes() < 10) {
			minutes = "0" + minutes;
		} 
		
		// Finds current hours in local time. Chooses if tag should be am or pm.
		if (getCurrentHours() > 12) {
			return getCurrentHours() + ":" + minutes + " PM";
		} else {
			return getCurrentHours() + ":" + minutes + " AM";
		}
	}

	// Finds local time in minutes.
	public long getMinutes() {
		return System.currentTimeMillis() / MILLIS_CONVERSION / 60;
	}

	// Calculates local time in minutes.
	private long getCurrentMinutes() {
		return getMinutes() % 60;
	}

	// Finds local time in hours.
	public long getHours() {
		return getMinutes() / 60;
	}

	// Calculates current hours.
	public int getCurrentHours() {
		return (int) (getHours() % 24);
	}

	//TODO
	String currentTime(int difference) {
		String minutes = String.valueOf(getCurrentMinutes());
		
		//TODO
		if (getCurrentMinutes() < 10) {
			minutes = "0" + minutes;
		}
		
		//TODO
		if (getCurrentHours() <= Math.abs(difference) && difference < 0) {
			if (converTime(getCurrentHours()) + difference > 12) {
				return convertTime(getCurrentHours()) 
						+ difference + ":" + minutes + " PM";
			} else {
				return convertTime(getCurrentHours()) 
						+ difference + ":" + minutes + " AM";
			}
		}
		
		//TODO
		if (getCurrentHours() > 12) {
			return getCurrentHours() + difference + ":" + minutes + " PM";
		} else {
			return getCurrentHours() + difference + ":" + minutes + " AM";
		}
		
	}
	
	// Prints out current date and time of local.
	@Override
	void dateTimeNow() {
		System.out.println("Current Date/Time: ");
		
		// Creates new dateFormat and Gregorian Calendar.
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Calendar calendar = new GregorianCalendar();
		
		// Prints out the current local time.
		System.out.println(dateFormat.format(calendar.getTime()) + " ");
		System.out.println(currentTime() + "\n");
	}
	
	String dateTimeNowString(int difference) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Calendar calendar = new GregorianCalendar();
	}
	
}