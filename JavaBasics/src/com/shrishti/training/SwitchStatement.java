package com.shrishti.training;

public class SwitchStatement {
	public static void main(String[] args) {
		String choice = "read";

		switch (choice.toUpperCase()) {
			case "READ":
				System.out.println("Reading a file.");
				break;

			case "WRITE":
				System.out.println("Writing a file.");
				break;

			case "EXECUTE":
				System.out.println("Executing a file.");
				break;
	
			default:
				System.out.println("Invalid choice.");
				break;
		}
		
		
		String day = "Sunday";
		
		switch (day.toLowerCase()) {
			case "sunday":
			case "saturday":
				System.out.println("Enjoying weekend.");
				break;
			
			case "monday":
				System.out.println("Gloomy day. Starting to work.");
				break;
				
			case "friday":
				System.out.println("Waiting for weekend.");
				break;
				
			case "tuesday":
			case "wednesday":
			case "thursday":
				System.out.println("Busy with work.");
				break;
			
			default:
				System.out.println("Invalid day.");
				break;
		}
	}
}
