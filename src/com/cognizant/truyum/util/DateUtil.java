package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		Date convertedDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		simpleDateFormat.setLenient(true);
		try {
			convertedDate = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertedDate;
	}
}
