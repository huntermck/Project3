import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

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

	int convertTime(int time) {
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
			if (convertTime(getCurrentHours()) + difference > 12) {
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
		
		return dateFormat.format(calendar.getTime()) + " "
				+ currentTimeNOAMPM(difference);
	}
	
	String currentTimeNOAMPM(int difference) {
		String minutes = String.valueOf(getCurrentMinutes());
		if (getCurrentMinutes() < 10) {
			minutes = "0" + minutes;
		} if (getCurrentHours() <= Math.abs(difference) && difference < 0) {
			return convertTime(getCurrentHours()) + difference
					+ ":" + minutes;
		} else {
			return getCurrentHours() + difference + ":" + minutes;
		}
	}
	
	@Override
	void sleepForFiveSec() {
		int currentSeconds = getValueOfSecond();
		
		// DEsc.
		while (getValueOfSecond() < currentSeconds + 5) {
			;
		}
	}
	
	@Override 
	void dateTimeDifferentZone() {
		LinkedHashMap <String, Integer> zoneMap = new LinkedHashMap <String, Integer>();
		
		// Desc.
		zoneMap.put("GMT",  0);
		zoneMap.put("BST", 6);
		zoneMap.put("CST", -5);
		
		// Desc.
		for (Map.Entry <String, Integer> entry : zoneMap.entrySet()) {
			System.out.println(entry.getKey() + ": "
					+ dateTimeNowString(entry.getValue()));
		}
	}
	
	//DESC.
	@Override
	void timeZoneHashMap() {
		// Creates the two simpledateformat objects.
		SimpleDateFormat MDY = new SimpleDateFormat("M/dd/yyyy");
		SimpleDateFormat YMD = new SimpleDateFormat("yyyy-M-dd");
		
		// Created Gregorian Calendar.
		Calendar calendar = new GregorianCalendar();
		
		// Creates linkedhashmap zoneMap.
		LinkedHashMap <String, String> zoneMap = new LinkedHashMap <String, String>();
	
		// Creates zoneMaps of various time zones, and adjusts appropriately for them.
		zoneMap.put("GMT", currentTimeNOAMPM(0));
		zoneMap.put("BST", currentTimeNOAMPM(6));
		zoneMap.put("CST", currentTimeNOAMPM(-5));
		zoneMap.put("ZST", currentTimeNOAMPM(-1));
		zoneMap.put("AST", currentTimeNOAMPM(-1));
		
		// Prints out v1 of output.
		System.out.println("Print Style 1:");
		for (Map.Entry <String, String> entry : zoneMap.entrySet()) {
			System.out.println(entry.getKey() + " "
					+ MDY.format(calendar.getTime()));
		}
		
		// Prints out v2 of output.
		System.out.println("Print Style 2:");
		for (Map.Entry <String, String> entry : zoneMap.entrySet()) {
			System.out.println(MDY.format(calendar.getTime()) + " "
					+ entry.getValue());
		}
		
		// Prints out v3 of output.
		System.out.println("Print Style 3: Final Sorted Array");
		for (Map.Entry <String, String> entry : zoneMap.entrySet()) {
			System.out.println(YMD.format(calendar.getTime()) + "T"
					+ entry.getValue());
		}
		
	}

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub
		
	}
	
}