package com.abs.quest1;

public abstract class TeamLead extends Employee {

	public TeamLead(String empName, int empId, double salary, String companyname) {
		super(empName, empId, salary, companyname);
	}

	@Override
	void calcBonus(double amount) {
		double bonus = amount * 0.50;
		System.out.println(String.format("Team Lead bonus is ₹%.2f", bonus));
	}

	void corporateServices() {
		System.out.println(
				"TeamLead services offered to corporates: Building tech team from scratch, Give vision & direction to coding projects.");
	}
}
