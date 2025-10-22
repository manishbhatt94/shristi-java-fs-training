package com.getbusticks.app;

public class Ticket {

	private int ticketId;
	private Passenger passenger;
	private Bus bus;

	private static int nextTicketId = 1001;

	public Ticket(Passenger passenger, Bus bus) {
		super();
		this.ticketId = nextTicketId++;
		this.passenger = passenger;
		this.bus = bus;
	}

	@Override
	public String toString() {
		return getTicketInfo();
	}

	public String getTicketInfo() {
		return String.format("Ticket ID: %d\n" + "%s\n" + "%s", ticketId, passenger.getPassengerInfo(),
				bus.getBusInfo());
	}
}
