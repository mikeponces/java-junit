package com.pluralsight.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClinicCalendarShould {

	private ClinicCalendar calendar;

	@BeforeEach
	void init() {
		calendar = new ClinicCalendar(LocalDate.now());
	}
 
	@Test
	public void allowEntryOfAnAppointment() {
		calendar.addAppointment("Jim", "Weaver", "avery", "09/01/2018 2:00pm");

		List<PatientAppointment> appointments = calendar.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());

		PatientAppointment appointment = appointments.get(0);
//		assertEquals("Jim", appointment.getFirstName());
//		assertEquals("Weaver", appointment.getLastName());

		assertAll(() -> assertEquals("Jim", appointment.getFirstName()),
				() -> assertEquals("Weaver", appointment.getLastName()));
	}

}
