package com.over.quest2;

public class MessengerMain {

	public static void main(String[] args) {
		Messenger messenger = new Messenger();

		System.out.println("Trying out Messenger class...");

		messenger.sendMail("Hello world");

		messenger.sendMail("manishb94", "I think it's gonna rain today.");

		messenger.sendMail("manish_the_manager",
				"Need to get on a short 20 minute call to discuss the project requirements with the team.",
				"Request for a team sync up");
	}
}
