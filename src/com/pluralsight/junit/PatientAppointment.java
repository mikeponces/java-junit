package com.pluralsight.junit;

public class PatientAppointment {

	private String firstName;
	private String lastName;
	private String email;
	private String date;

	public PatientAppointment(String firstName, String lastName, String email, String date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}
}
