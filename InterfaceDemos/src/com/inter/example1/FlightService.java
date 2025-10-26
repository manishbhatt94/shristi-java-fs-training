package com.inter.example1;

public class FlightService implements IBooking {

	@Override
	public void bookTicket(int noOfTickets) {
		System.out.println("Booked " + noOfTickets + " tickets for flight.");
	}

	@Override
	public void cancelTicket(int noOfTickets) {
		System.out.println("Cancelled " + noOfTickets + " tickets for flight.");
	}

	// own methods
	void showFacilities() {
		System.out.println("Expensive food & refreshments served in cabin.");
	}
}
