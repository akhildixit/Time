package com.time.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Akhil Dixit
 * 
 */
public class RelativeTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RelativeTimer().compareToNow("31-03-1991 13:50:40", "dd-MM-yyyy HH:mm:ss"));
	}

	/**
	 * @param dateString
	 * @param format
	 * @return Relative time from/till now. Returns null in case of any exception.
	 */
	public String compareToNow(String dateString, String format) {
		DateFormat myDateFormat = new SimpleDateFormat(format);
		Date lastDate = new Date(System.currentTimeMillis());
		Date firstDate = null;
		try {
			firstDate = myDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		long first = firstDate.getTime();
		long last = lastDate.getTime();
		if (first > last) {
			return "In "+findDifference(last, first);
		}
		return findDifference(first, last)+" ago";
	}

	/**
	 * @param first
	 * @param last
	 * @return Approximate time difference between first to last
	 */
	private String findDifference(long first, long last) {
		long diff = last - first;
		if (diff < 1000) {
			return (diff + " millisecond(s)");
		}
		diff /= 1000;
		if (diff < 60) {
			return (diff + " second(s)");
		}
		diff /= 60;
		if (diff < 60) {
			return (diff + " minute(s)");
		}
		diff /= 60;
		if (diff < 24) {
			return (diff + " hour(s)");
		}
		diff /= 24;
		if (diff < 365) {
			return (diff + " day(s)");
		}
		diff /= 365;
		return (diff + " year(s)");
	}
}