package com.pluralsight.junit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeConverter {

	public static LocalDateTime convertStringToDateTime(String time, LocalDate date) {
		return LocalDateTime.of(date, LocalTime.parse(time));
	}

}
