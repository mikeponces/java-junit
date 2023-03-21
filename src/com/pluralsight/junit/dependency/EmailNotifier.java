package com.pluralsight.junit.dependency;

public interface EmailNotifier {
	void sendNotification(String subject, String body, String address);
}
