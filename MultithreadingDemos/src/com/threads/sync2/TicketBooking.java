package com.threads.sync2;

public class TicketBooking {

	private static final double COST_PER_TICKET = 120.0;

	private int availableTickets = 60;

	public double bookTicket(String passengerName, int numOfTickets) {
		String threadName = Thread.currentThread().getName();
		System.out.printf("[%s / bookTicket()] Booking Ticket for: %s.\n", threadName, passengerName);
		System.out.printf("[%s / bookTicket()] Tickets needed: %d (Available: %d).\n", threadName, numOfTickets,
				availableTickets);
		if (availableTickets - numOfTickets <= 0) {
			throw new RuntimeException(String.format("[%s / bookTicket()] Tickets sold out!", threadName));
		}
		availableTickets -= numOfTickets;
		System.out.printf("[%s / bookTicket()] Booked %d tickets for %s. NOW - Tickets remaining: %d.\n", threadName,
				numOfTickets, passengerName, availableTickets);
		// connect to the database, and
		// check for num of tickets & category
		// so during that time, we'll make the thread sleep
		// to simulate a DB call
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double price = COST_PER_TICKET * numOfTickets;
		System.out.printf("[%s / bookTicket()] Total Price: %.2f.\n", threadName, price);
		return price;
	}
}
