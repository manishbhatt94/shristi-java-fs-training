package com.inter.ex1;

// Methods not implemented:
// showActivities() method of IActivityClub
// outdoor() method of IGames
public abstract class TeamLeader extends Employee implements IGames {

	private double salary;

	public TeamLeader(String employeeName, int employeeId, String city, double salary) {
		super(employeeName, employeeId, city);
		this.salary = salary;
	}

	// from IInsurance
	@Override
	public void showPolicyDetails() {
		System.out.println("Policy provided for health - TeamLeader");
	}

	// from Employee
	@Override
	void projectDetails() {
		System.out.println("For E-Commerce domain");
		System.out.println("Using MERN stack");
	}

	// from Employee
	@Override
	void calcBonus(double amount) {
		System.out.println("Diwali Bonus for TL: " + amount);
	}

	// from IGames (outdoor method not implemented)
	@Override
	public String[] indoor() {
		return new String[] { "Chess", "Table Tennis" };
	}

	// own method(s) for TeamLeader
	String[] mandateCertifications() {
		return new String[] { "Cloud", "Communications", "Leadership", "Kubernetes" };
	}
}
