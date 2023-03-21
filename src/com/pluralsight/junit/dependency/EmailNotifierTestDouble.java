package com.pluralsight.junit.dependency;

import java.util.ArrayList;

public class EmailNotifierTestDouble implements EmailNotifier {

	ArrayList<Message> receivedMessages = new ArrayList<>();

	@Override
	public void sendNotification(String subject, String body, String address) {
		receivedMessages.add(new Message(subject, body, address));
	}

	public ArrayList<Message> getReceivedMessages() {
		return receivedMessages;
	}
}
