package com.oops.basics;

public class Student {
	int studId;
	String name;
	String department;
	
	Student() {
		studId = 10;
		name = "John";
		department = "Pathology";
	}

	void getDetails() {
		System.out.println("Student ID: " + this.studId);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
	}

	String greet() {
		return "Have a great day";
	}

	double printAvg(int marks1, int marks2) {
		return (marks1 + marks2) / 2.0;
	}
	
	String[] showCourses() {
		// String[] courses = {"Java", "Spring"};
		String[] courses = new String[] {"Java", "Spring"};
		return courses;
	}
}
