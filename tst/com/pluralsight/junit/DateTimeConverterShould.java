package com.pluralsight.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DateTimeConverterShould {

	@Nested
	@DisplayName("convert string with 'today' keyword")
	class TodayTests {
		@Test
		@DisplayName("correctly")
		void convertTodayStringCorrectly() {
			LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 1:00 pm", LocalDate.of(2018, 9, 1));
			assertEquals(result, LocalDateTime.of(2018, 9, 1, 13, 0),
					() -> "Failed to convert 'today' string to expected date time");
		}
	}

	@Test
	void convertCorrectPatternToDateTime() {
		LocalDateTime result = DateTimeConverter.convertStringToDateTime("1:00 pm", LocalDate.of(2018, 9, 1));
		assertEquals(result, LocalDateTime.of(2018, 9, 2, 13, 0));
	}

	@Test
	void throwExceptionIfIncorrectPatternProvided() {
		assertThrows(RuntimeException.class,
				() -> DateTimeConverter.convertStringToDateTime("9/2/18 100 pm", LocalDate.of(2018, 9, 1)));

	}

	@Test
	void throwExceptionWithMessageIfIncorrectPatternProvided() {
		Throwable error = assertThrows(RuntimeException.class,
				() -> DateTimeConverter.convertStringToDateTime("9/2/18 100 pm", LocalDate.of(2018, 9, 1)));
		assertEquals("Text '9/2/18 100 pm' could not be parsed at index 0", error.getMessage());
	}
}
