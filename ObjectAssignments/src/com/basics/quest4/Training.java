package com.basics.quest4;

public class Training {

	private static String[] courses = { "Distributed System", "Computer Graphics", "Memory Management" };
	private static String[] trainers;

	public static void setTrainers(String... trainers) { // method accepting a var-args parameter
		Training.trainers = trainers;
	}

	public static void showTrainers() {
		if (trainers == null) {
			System.out.println("The'trainers' property is not yet set.\n"
					+ "Call Training.setTrainers(String... trainers) first, to set 'trainers',\n"
					+ "before calling Training.showTrainers()");
			return;
		}
		System.out.println("\nPrinting trainers list:");
		for (String trainer : trainers) {
			System.out.println("Trainer: " + trainer);
		}
		System.out.println();
	}

	public static String[] getCourses() {
		return Training.courses;
	}
}
