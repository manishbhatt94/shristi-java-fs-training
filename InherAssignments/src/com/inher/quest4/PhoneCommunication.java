package com.inher.quest4;

public class PhoneCommunication extends Communication {

	@Override
	void sendMessage() {
		System.out.println("Communication through phone / mobile verbally");
	}

	void callService() {
		System.out.println("Can be local, international or Subscriber trunk dialing STD");
	}
}
