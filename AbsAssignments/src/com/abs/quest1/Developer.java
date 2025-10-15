package com.abs.quest1;

public class Developer extends TeamLead {

	public Developer(String empName, int empId, double salary, String companyname) {
		super(empName, empId, salary, companyname);
	}

	@Override
	void showProjects() {
		System.out.println("Developer projects: Refactoring, Reviewing code, Deployment monitoring.");
	}

	void showHobbies() {
		System.out.println("Developer hobbies include: Sleeping, Taking walks, Watching comedy shows.");
	}
}
