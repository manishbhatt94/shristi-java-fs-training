package com.inter.example1;

public interface IBooking {

	String AGENCY_NAME = "Akash Travel Agents";

	void bookTicket(int noOfTickets);

	void cancelTicket(int noOfTickets);
}
