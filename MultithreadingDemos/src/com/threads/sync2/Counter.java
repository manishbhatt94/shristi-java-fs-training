package com.threads.sync2;

public class Counter implements Runnable {

	private String passengerName;
	private int numOfTickets;
	private TicketBooking booking;
	private Thread thread;

	public Counter(String passengerName, int numOfTickets, TicketBooking booking) {
		super();
		this.passengerName = passengerName;
		this.numOfTickets = numOfTickets;
		this.booking = booking;
		thread = new Thread(this, passengerName + "-Thread");
		thread.start();
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("[%s / Counter::run() / before sync block] Welcome to OnlineTicketBooking.\n", threadName);
		System.out.printf("[%s / Counter::run() / before sync block] Checking details.\n", threadName);
		synchronized (booking) {
			System.out.printf("[%s / Counter::run() / inside sync block] Welcome: %s.. Trying to book %d tickets.\n",
					threadName, passengerName, numOfTickets);
			double totalPrice = booking.bookTicket(passengerName, numOfTickets);
			System.out.printf("[%s / Counter::run() / inside sync block] Booking confirmed. Total fare = %.2f.\n",
					threadName, totalPrice);
		}
		System.out.printf("[%s / Counter::run() / after sync block] -- Booking success -- Post-processing.\n",
				threadName);
	}

}
