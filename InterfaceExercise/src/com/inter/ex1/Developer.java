package com.inter.ex1;

public class Developer extends TeamLeader {

	private String email;

	public Developer(String employeeName, int employeeId, String city, double salary, String email) {
		super(employeeName, employeeId, city, salary);
		this.email = email;
	}

	// from IGames
	@Override
	public String[] outdoor() {
		System.out.println("Games for developer");
		return new String[] { "Cricket", "Football" };
	}

	// from IActivityClubs
	@Override
	public void showActivities() {
		System.out.println("Activities available: Trekking, Yoga, Games - Developer");
		System.out.println("Weekend team dinner");
	}

	// re-override methods from TeamLeader

	@Override
	public void showPolicyDetails() {
		super.showPolicyDetails();
		System.out.println("Policy for vehicles - Developer");
	}

	@Override
	void calcBonus(double amount) {
		System.out.println("Diwali bonus for developer: " + amount);
	}

	@Override
	public String[] indoor() {
		return new String[] { "Squash", "Carrom" };
	}

	void skillsNeeded() {
		System.out.println("Backend: Java, Spring");
		System.out.println("Frontend: React");
		System.out.println("Devops: Jenkins, CI/CD pipelines");
	}
}
