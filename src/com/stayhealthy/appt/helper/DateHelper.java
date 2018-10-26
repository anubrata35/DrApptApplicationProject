package com.stayhealthy.appt.helper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	public static String getTimeStampOnly(Date date) {

		String timestamp = "";

		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");

		if (date != null)
			timestamp = formatter.format(date);

		return timestamp;

	}

	public static String getDateOnly(Date date) {

		String timestamp = "";

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMMM-yyyy");

		if (date != null)
			timestamp = formatter.format(date);

		return timestamp;

	}

	public static String getDateInformat(Date date) {

		String timestamp = "";

		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

		if (date != null)
			timestamp = formatter.format(date);

		return timestamp;

	}

	public static String getDateTime12hour(Date date) {

		String timestamp = "";

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
		if (date != null)
			timestamp = formatter.format(date);

		return timestamp;

	}

	public static Date getAppointmentDate(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = null;
		try {
			dt = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dt;
	}

	public static String getDayofWeek(Date dt) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(dt);

		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return "SUNDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
			return "WEDNESDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return "MONDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
			return "TUESDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
			return "TUESDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
			return "THURSDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			return "FRIDAY";
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return "SATURDAY";
		}

		return null;
	}

	public static void main(String[] args) {

		System.out.println(getDateInformat(new Date()));

		String dateString = "10/09/2017";

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Timestamp: " + sdf.format(timestamp));

		Date ddd = null;
		try {
			ddd = sdf.parse(dateString);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(ddd);

		// Date dt = new Date();

		// calendar.add(Calendar.DAY_OF_MONTH ,60);

		System.out.println(" Date is :  " + calendar.getTime() + " :: " + calendar.get(Calendar.DAY_OF_WEEK));
		// System.out.println(DateHelper.getTimeStampOnly(dt));

		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			System.out.println("SUNDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
			System.out.println("WEDNESDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			System.out.println("MONDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
			System.out.println("TUESDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
			System.out.println("TUESDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
			System.out.println("THURSDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			System.out.println("FRIDAY");
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			System.out.println("SATURDAY");
		}

	}

}
