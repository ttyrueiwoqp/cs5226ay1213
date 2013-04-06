package com.nus.cs.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static Date addDayToDate(Date aDate, int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDate);
		cal.add(Calendar.DATE, noOfDays);

		return new Date(cal.getTime().getTime());
	}

	public static Date addMinuteToDate(java.util.Date tempStartDate, int noOfMins) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(tempStartDate);
		cal.add(Calendar.MINUTE, noOfMins);

		return new Date(cal.getTime().getTime());
	}

	public static String getDateString(Date aDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		return sdf.format(aDate);
	}
}
