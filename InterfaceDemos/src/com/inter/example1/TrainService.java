package com.inter.example1;

public class TrainService implements IBooking {

	@Override
	public void bookTicket(int noOfTickets) {
		System.out.println("Booked " + noOfTickets + " tickets for train.");
	}

	@Override
	public void cancelTicket(int noOfTickets) {
		System.out.println("Cancelled " + noOfTickets + " tickets for train.");
	}

	// own methods
	void showCoachTypes() {
		System.out.println("AC Chair Car, Sleeper, General, AC 2/3 Tier.");
	}
}
