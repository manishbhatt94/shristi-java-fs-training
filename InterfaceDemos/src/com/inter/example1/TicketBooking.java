package com.inter.example1;

public class TicketBooking {

	public static void main(String[] args) {
		System.out.println("Welcome to " + IBooking.AGENCY_NAME + "\n");

		IBooking booking;

		System.out.println("Booking flight tickets");
		booking = new FlightService();
		booking.bookTicket(3);
		booking.cancelTicket(2);
		FlightService flightService = (FlightService) booking;
		flightService.showFacilities();
		System.out.println();

		System.out.println("Booking train tickets");
		booking = new TrainService();
		booking.bookTicket(6);
		booking.cancelTicket(6);
		TrainService trainService = (TrainService) booking;
		trainService.showCoachTypes();
		System.out.println();

		System.out.println("Booking mini-bus tickets");
		booking = new MiniBusService();
		booking.bookTicket(2);
		booking.cancelTicket(1);
		MiniBusService miniBusService = (MiniBusService) booking;
		// inherited own method of BusService
		miniBusService.availDiscount();
		// own method of MiniBusService
		miniBusService.buyMonthlyPass();
		System.out.println();

		System.out.println(IBooking.AGENCY_NAME + " - Thanks for using our services. See you for your next adventure!");
	}
}
