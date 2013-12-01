package org.atrzaska.ebiznes.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtils {

	public static Date parseDate(String year, String month, String day,
			String hour, String minute, String second) {
		
		month = month.replace("Nov", "11");

		int year2 = Integer.parseInt(year);
		int month2 = Integer.parseInt(month);
		int day2 = Integer.parseInt(day);
		int hour2 = Integer.parseInt(hour);
		int minute2 = Integer.parseInt(minute);
		int second2 = Integer.parseInt(second);
		
		Calendar calendar = new GregorianCalendar();
		calendar.set(year2, month2, day2, hour2, minute2, second2);

    	return calendar.getTime();
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
}
