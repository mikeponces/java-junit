package com.pluralsight.junit.dependency;

public class Message {

	private String subject;
	private String body;
	private String address;

	public Message(String subject, String body, String address) {
		this.subject = subject;
		this.body = body;
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public String getAddress() {
		return address;
	}

}
