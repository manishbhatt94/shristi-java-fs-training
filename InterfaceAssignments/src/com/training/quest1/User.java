package com.training.quest1;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter choice ('s' / 'e') to view either student courses or employee courses");
		System.out.println("Enter 's' for student courses / 'e' for employee courses");
		System.out.print("Enter choice: ");
		String choice = scanner.nextLine().trim().toLowerCase();
		scanner.close();

		IInstitute institute = null;

		switch (choice) {
		case "s":
			System.out.println("\nShowing student courses:");
			institute = new StudentCourses();
			break;

		case "e":
			System.out.println("\nShowing employee courses:");
			institute = new EmployeeCourses();
			break;

		default:
			System.out.println("Invalid choice entered. Re-run the program & try again.");
			System.exit(0);
		}

		User.showCourses(institute);
	}

	public static void showCourses(IInstitute institute) {
		for (String course : institute.showCourses()) {
			System.out.println(course);
		}
	}
}
