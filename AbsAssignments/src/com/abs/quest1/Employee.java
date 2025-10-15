package com.abs.quest1;

import java.util.List;

public abstract class Employee {

	String empName;
	int empId;
	double salary;
	final String COMPANYNAME;

	static final List<String> validDesignations = List.of("developer", "teamlead", "manager");

	public Employee(String empName, int empId, double salary, String companyname) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
		this.COMPANYNAME = companyname;
	}

	abstract void calcBonus(double amount);

	abstract void showProjects();

	private void officeHours() {
		System.out.println("14 hours per day");
	}

	final void showRules() {
		officeHours();
		System.out.println("Leave policies");
		System.out.println("OD policies");
	}

	void printDetails() {
		System.out.println("\nEmployee Details:");
		System.out.println("Employee Name: " + empName);
		System.out.println("Employee ID: " + empId);
		System.out.println(String.format("Employee Salary = ₹%.2f", salary));
		System.out.println("Company name: " + COMPANYNAME);
	}

	String[] showCourses() {
		return new String[] { "Introduction to Management", "Generative AI for Dummies",
				"Tax Saving & Financial Security" };
	}
}
