package com.abs.quest1;

public class Manager extends Employee {

	String activity;

	public Manager(String empName, int empId, double salary, String companyname, String activity) {
		super(empName, empId, salary, companyname);
		this.activity = activity;
	}

	@Override
	void calcBonus(double amount) {
		double bonus = amount * 0.60;
		System.out.println(String.format("Manager bonus is ₹%.2f", bonus));
	}

	@Override
	void showProjects() {
		System.out.println("Manager projects: Hire for new project, Finalize appraisal figures.");
	}

	void funClub() {
		System.out.println("Activity: " + activity);
	}
}
