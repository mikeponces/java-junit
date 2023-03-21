package com.pluralsight.junit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClinicCalendar {

	private List<PatientAppointment> appointments;

	public ClinicCalendar() {
		appointments = new ArrayList<>();
	}

	public ClinicCalendar(LocalDate now) {
		this();
	}

	public void addAppointment(String firstName, String lastName, String username, String date) {
		PatientAppointment appointment = new PatientAppointment(firstName, lastName, username, date);
		appointments.add(appointment);
	}

	public List<PatientAppointment> getAppointments() {
		return appointments;
	}

	public List<PatientAppointment> getTommorowAppointments() {
		return appointments;
	}

}
