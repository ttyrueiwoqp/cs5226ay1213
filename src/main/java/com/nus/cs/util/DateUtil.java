package com.nus.cs.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String getDateAsString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		return sdf.format(date);
	}
	
	public static Date addMin(java.util.Date date, int min) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, min);

		return new Date(cal.getTime().getTime());
	}
	
	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);

		return new Date(cal.getTime().getTime());
	}
}
