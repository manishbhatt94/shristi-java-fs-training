package com.inter.ex1;

public class Manager extends Employee implements IArtsClub {

	private String department;

	public Manager(String employeeName, int employeeId, String city, String department) {
		super(employeeName, employeeId, city);
		this.department = department;
	}

	// from IActivityClubs
	@Override
	public void showActivities() {
		System.out.println("Activities available: Music, Arts, Trekking, Yoga, Games");
	}

	// from IInsurance
	@Override
	public void showPolicyDetails() {
		System.out.println("Policy provided for health");
	}

	// from IArtsClub
	@Override
	public void workshopDetails() {
		System.out.println("Oil Painting workshop - every 2nd weekend");
		System.out.println("Register soon");
	}

	// from IArtsClub
	@Override
	public String[] artClassTypes() {
		System.out.println("Different art sessions are provided");
		return new String[] { "Canvas Painting", "Oil Painting", "Sketching" };
	}
	
	// from Employee
	@Override
	void projectDetails() {
		System.out.println("For Banking domain");
		System.out.println("Using Java FullStack with Microservices");
	}

	// from Employee
	@Override
	void calcBonus(double amount) {
		System.out.println("Diwali Bonus: " + amount);
	}

	// own method(s) for Manager
	public String[] reporteesList() {
		return new String[] { "Raju", "Rakesh" };
	}
}
