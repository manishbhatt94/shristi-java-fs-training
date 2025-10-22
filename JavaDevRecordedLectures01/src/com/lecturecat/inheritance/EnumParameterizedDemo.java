package com.lecturecat.inheritance;

import java.util.Scanner;

enum Vehicle {
	SKODA("Sedan", 18000.90), SCORPIO("SUV", 20000.90), NANO("MINI", 1003.90);

	String features;
	double price;

	Vehicle(String features, double price) {
		this.features = features;
		this.price = price;
	}
}

public class EnumParameterizedDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a vehicle (choose amongst: SKODA / SCORPIO / NANO):");
		String choice = sc.next().toUpperCase();
		sc.close();
		
		Vehicle[] enumArray = Vehicle.values();
		
		Vehicle vehicle = null;
		boolean found = false;
		for (Vehicle v : enumArray) {
			if (v.name().equals(choice)) {
				found = true;
				vehicle = Vehicle.valueOf(choice);
				break;
			}
		}
		
		if (!found) {
			System.out.println("Entered invalid vehicle of choice (from SKODA / SCORPIO / NANO)." + "\n\""
					+ choice + "\" - no such enum constant is defined in enum Vehicle." + "\nExiting!");
			System.exit(0);
		}
		
		switch (vehicle) {
		case SKODA:
			System.out.println("Your choice is Skoda.");
			System.out.println("Type: " + vehicle.features);
			System.out.println(String.format("Price: ₹%.2f", vehicle.price));
			break;
			
		case SCORPIO:
			System.out.println("Your choice is Mahindra Scorpio.");
			System.out.println("Type: " + vehicle.features);
			System.out.println(String.format("Price: ₹%.2f", vehicle.price));
			break;
		
		case NANO:
			System.out.println("Your choice is Tata Nano.");
			System.out.println("Type: " + vehicle.features);
			System.out.println(String.format("Price: ₹%.2f", vehicle.price));
			break;
		}
	}
}
