package com.inter.example1;

public abstract class BusService implements IBooking {

	@Override
	public void bookTicket(int noOfTickets) {
		System.out.println("Booked " + noOfTickets + " ticket(s) for bus.");
	}

	public void availDiscount() {
		System.out.println("Festive discount available.");
	}
}
