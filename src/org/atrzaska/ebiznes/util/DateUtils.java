package org.atrzaska.ebiznes.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	public static Date parseDate(String year, String month, String day,
			String hour, String minute, String second) {
		
		month.replace("Nov", "11");

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
}
