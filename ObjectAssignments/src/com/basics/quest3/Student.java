package com.basics.quest3;

public class Student {

	String name;
	String department;

	public Student(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}

	void printDetails() {
		System.out.println("\nStudent name: " + name);
		System.out.println("Student department: " + department);
	}

	String getGrades(int[] marks) {
		double sum = 0.0;
		for (int score : marks) {
			sum += score;
		}
		double average = sum / marks.length;

		String grade = "";

		// grade computation
		if (average >= 90) {
			grade = "A";
		} else if (average >= 80) {
			grade = "B";
		} else if (average >= 70) {
			grade = "C";
		} else if (average >= 60) {
			grade = "D";
		} else if (average >= 50) {
			grade = "E";
		} else {
			grade = "Fail";
		}

		return grade;
	}
}
