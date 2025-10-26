package com.inter.example1;

public class MiniBusService extends BusService {

	@Override
	public void cancelTicket(int noOfTickets) {
		System.out.println("Cancelled " + noOfTickets + " tickets for bus.");
	}

	// own methods
	public void buyMonthlyPass() {
		System.out.println("Purchased monthly pass for city mini bus travel.");
	}
}
