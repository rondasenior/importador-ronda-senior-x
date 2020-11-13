package br.com.senior.importadorrondaseniorx.utils;

public class DateUtils {

	public static String formatDateTimeUsingGMT(String date, int offset) {
		int timeZoneHour = offset / 60;
		int timeZoneMinute = Math.abs(offset % 60);
		String signal = "-";
		if (timeZoneHour >= 0) {
			signal = "+";
		}
		String hour = convertTimeZoneToGMTHour(timeZoneHour);
		String minute = convertTimeZoneToGMTMinute(timeZoneMinute);
		
		return date + signal + hour + minute;
	}
	
	private static String convertTimeZoneToGMTHour(int timeZoneHour) {
		if (timeZoneHour >= 0) {
			if (timeZoneHour < 10) {
				return "0" + timeZoneHour;
			}
			return String.valueOf(timeZoneHour);
		}
		
		if (timeZoneHour > -10) {
			timeZoneHour = timeZoneHour * -1;
			return "0" + timeZoneHour;
		}
		
		return String.valueOf(timeZoneHour);
	}
	
	private static String convertTimeZoneToGMTMinute(int timeZoneMinute) {
		if (timeZoneMinute < 10) {
			return "0" + timeZoneMinute;
		}
		return String.valueOf(timeZoneMinute);
	}
}
