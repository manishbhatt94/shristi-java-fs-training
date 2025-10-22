package com.getbusticks.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {

	private static List<Route> routes;
	private static List<Bus> buses;
	private static List<Ticket> tickets;
	private static Scanner scanner;

	public static void main(String[] args) {

		// 1️ Initialize data
		routes = SeedData.createRoutes();
		buses = SeedData.createBuses(routes); // predefined seed data
		tickets = new ArrayList<>();
		scanner = new Scanner(System.in);

		int choice = 0;

		// 2️⃣ Main Menu Loop
		do {
			System.out.println("\n========== ONLINE BUS TICKET BOOKING SYSTEM ==========");
			System.out.println("1. View All Available Buses");
			System.out.println("2. Search Bus by Route");
			System.out.println("3. Book a Ticket");
			System.out.println("4. View All Booked Tickets");
			System.out.println("5. Exit");
			System.out.print("Enter your choice (1-5): ");
			choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				viewAllBuses();
				break;
			case 2:
				searchBusByRoute();
				break;
			case 3:
				bookTicket();
				break;
			case 4:
				viewBookedTickets();
				break;
			case 5:
				System.out.println("\nThank you for using the booking system. Goodbye!");
				break;
			default:
				System.out.println("\nInvalid choice! Please try again.");
			}

		} while (choice != 5);

		scanner.close();
	}

	// ============================================================
	// 1️ View All Buses
	// ============================================================
	private static void viewAllBuses() {
		System.out.println("\n--- List of All Available Buses ---");
		for (Bus bus : buses) {
			System.out.println(bus.getBusInfo());
		}
	}

	// ============================================================
	// 2️ Search Bus by Route (Source → Destination)
	// ============================================================
	private static void searchBusByRoute() {
		System.out.print("\nEnter Source City: ");
		String source = scanner.nextLine().trim();
		System.out.print("Enter Destination City: ");
		String destination = scanner.nextLine().trim();

		List<Bus> matchingBuses = new ArrayList<>();
		for (Bus bus : buses) {
			Route route = bus.getRoute();
			if (route.getSource().equalsIgnoreCase(source) && route.getDestination().equalsIgnoreCase(destination)) {
				matchingBuses.add(bus);
			}
		}

		if (matchingBuses.isEmpty()) {
			System.out.println("No buses found for the given route.");
		} else {
			System.out.println("\nBuses available for " + source + " → " + destination + ":");
			for (Bus bus : matchingBuses) {
				System.out.println(bus.getBusInfo());
			}
		}
	}

	// ============================================================
	// 3️ Book a Ticket
	// ============================================================
	private static void bookTicket() {
		System.out.print("\nEnter Source City: ");
		String source = scanner.nextLine().trim();
		System.out.print("Enter Destination City: ");
		String destination = scanner.nextLine().trim();

		List<Bus> matchingBuses = new ArrayList<>();
		for (Bus bus : buses) {
			Route route = bus.getRoute();
			if (route.getSource().equalsIgnoreCase(source) && route.getDestination().equalsIgnoreCase(destination)) {
				matchingBuses.add(bus);
			}
		}

		if (matchingBuses.isEmpty()) {
			System.out.println("No buses found for the given route.");
			return;
		}

		System.out.println("\nAvailable buses for " + source + " → " + destination + ":");
		for (int i = 0; i < matchingBuses.size(); i++) {
			System.out.println((i + 1) + ". " + matchingBuses.get(i).getBusInfo());
		}

		System.out.print("\nEnter your choice (1-" + matchingBuses.size() + "): ");
		int busChoice = scanner.nextInt();
		scanner.nextLine(); // consume newline

		if (busChoice < 1 || busChoice > matchingBuses.size()) {
			System.out.println("Invalid bus selection!");
			return;
		}

		Bus selectedBus = matchingBuses.get(busChoice - 1);

		if (!selectedBus.bookSeat()) {
			System.out.println("Sorry, no seats available on this bus.");
			return;
		}

		// Collect passenger details
		System.out.print("Enter passenger name: ");
		String name = scanner.nextLine();
		System.out.print("Enter passenger age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter passenger gender (M/F): ");
		String gender = scanner.nextLine();

		Passenger passenger = new Passenger(name, age, gender);
		Ticket ticket = new Ticket(passenger, selectedBus);
		tickets.add(ticket);

		System.out.println("\n✅ Ticket booked successfully!");
		System.out.println(ticket.getTicketInfo());
	}

	// ============================================================
	// 4️ View Booked Tickets
	// ============================================================
	private static void viewBookedTickets() {
		System.out.println("\n--- All Booked Tickets ---");
		if (tickets.isEmpty()) {
			System.out.println("No tickets booked yet.");
		} else {
			for (Ticket ticket : tickets) {
				System.out.println(ticket.getTicketInfo());
				System.out.println("-------------------------------------");
			}
		}
	}
}
