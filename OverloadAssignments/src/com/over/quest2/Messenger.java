package com.over.quest2;

public class Messenger {

	void sendMail(String message) {
		System.out.println("\nSending Mail (summary below):");
		System.out.println("Mail Body: " + message);
	}

	void sendMail(String toUsername, String message) {
		System.out.println("\nSending Mail (summary below):");
		System.out.println("Mail Recipient: " + toUsername);
		System.out.println("Mail Body: " + message);
	}

	void sendMail(String toUsername, String message, String subject) {
		System.out.println("\nSending Mail (summary below):");
		System.out.println("Mail Recipient: " + toUsername);
		System.out.println("Mail Subject: " + subject);
		System.out.println("Mail Body: " + message);
	}
}
