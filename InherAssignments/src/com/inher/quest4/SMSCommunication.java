package com.inher.quest4;

public class SMSCommunication extends Communication {

	@Override
	void sendMessage() {
		System.out.println("Communication through short messaging service");
	}

	void messageLength() {
		System.out.println("Short messages of up to 160 characters");
	}
}
