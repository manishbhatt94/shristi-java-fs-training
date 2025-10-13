package com.inher.quest4;

public class WhatsappCommunication extends Communication {

	@Override
	void sendMessage() {
		System.out.println("Communication using WhatsApp");
	}

	void otherFeatures() {
		System.out.println("send photos, videos, audio, documents, and messages");
	}
}
