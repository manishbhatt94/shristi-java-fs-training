package com.basics.quest4;

import java.util.Scanner;

public class CourseMain {

	public static void main(String[] args) {
		String[] trainers = CourseMain.readTrainers();
		/*
		 * Training.setTrainers(trainers);
		 * 
		 * Here, Java automatically unpacks an array to individual arguments, when we
		 * pass an array as an argument to a method that accepts a var-args parameter
		 */
		Training.setTrainers(trainers);
		Training.showTrainers();

		CourseMain.displayCourses();
	}

	/**
	 * Prompts user to input an array of trainers' names, and returns the same to caller.
	 * 
	 * @return the user input String array of trainers
	 */
	private static String[] readTrainers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter names of trainers in the Training institue");

		System.out.print("First, enter the number of trainers: ");
		int trainersCount = sc.nextInt();
		sc.nextLine();
		String[] trainers = new String[trainersCount];

		System.out.println("Enter the names of " + trainersCount + " trainers in separate lines:");

		for (int i = 0; i < trainersCount; i++) {
			System.out.print("Enter name of trainer #" + (i + 1) + ": ");
			trainers[i] = sc.nextLine();
		}

		sc.close();

		return trainers;
	}

	private static void displayCourses() {
		String[] courses = Training.getCourses();

		System.out.println("\nList of courses offered at Training Institute:");
		for (String course : courses) {
			System.out.println("Course: " + course);
		}
		System.out.println();
	}
}
