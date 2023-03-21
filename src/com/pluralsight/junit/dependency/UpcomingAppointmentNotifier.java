package com.pluralsight.junit.dependency;

import com.pluralsight.junit.ClinicCalendar;
import com.pluralsight.junit.PatientAppointment;

public class UpcomingAppointmentNotifier {
	private ClinicCalendar calendar;
	private EmailNotifier notifier;

	public UpcomingAppointmentNotifier(ClinicCalendar calendar, EmailNotifier notifier) {
		this.calendar = calendar;
		this.notifier = notifier;
	}

	public void run() {
		for (PatientAppointment appt : calendar.getTommorowAppointments()) {
			String email = appt.getEmail();
			notifier.sendNotification("Appointment Reminder", buildMessageBody(appt), email);
		}
	}

	private String buildMessageBody(PatientAppointment appt) {
		return null;
	}
}
