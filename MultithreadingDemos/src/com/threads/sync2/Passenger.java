package com.threads.sync2;

public class Passenger {

	public static void main(String[] args) {
		TicketBooking booking = new TicketBooking();
		Counter counter1 = new Counter("Raju", 20, booking);
		Counter counter2 = new Counter("Rakesh", 30, booking);
		Counter counter3 = new Counter("Rohan", 15, booking);

		try {
			counter1.getThread().join();
			counter2.getThread().join();
			counter3.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nAll counters done with passengers.");
	}
}
