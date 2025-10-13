package com.inher.quest4;

public class MailCommunication extends Communication {

	@Override
	void sendMessage() {
		System.out.println("Communication using mail service");
	}

	String[] showTypes() {
		return new String[] { "email", "telegram", "letter" };
	}
}
