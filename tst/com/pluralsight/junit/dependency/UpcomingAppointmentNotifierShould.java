package com.pluralsight.junit.dependency;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pluralsight.junit.ClinicCalendar;

class UpcomingAppointmentNotifierShould {

	EmailNotifierTestDouble emailDouble;

	@BeforeEach
	void init() {
		emailDouble = new EmailNotifierTestDouble();
	}

	@Test
	void sendNotificationWithCorrectFormat() {
		UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(new ClinicCalendar(), emailDouble);
		notifier.run();

		assertEquals(0, emailDouble.getReceivedMessages().size());

		Message expectedMessage = emailDouble.getReceivedMessages().get(0);

		assertAll(() -> assertEquals("address", expectedMessage.getAddress()),
				() -> assertEquals("subject", expectedMessage.getSubject()),
				() -> assertEquals("body", expectedMessage.getBody()));
	}

}
