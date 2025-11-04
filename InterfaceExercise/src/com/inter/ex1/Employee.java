package com.inter.ex1;

public abstract class Employee implements IInsurance, IActivityClubs {

	private String employeeName;
	private int employeeId;
	private String city;

	public Employee(String employeeName, int employeeId, String city) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.city = city;
	}

	abstract void projectDetails();

	abstract void calcBonus(double amount);

	void printDetails() {
		System.out.println("Name: " + employeeName);
		System.out.println("Id: " + employeeId);
		System.out.println("City: " + city);
	}
}
