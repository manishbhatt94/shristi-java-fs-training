package com.oops.override;

public class EmpOverride {

	public static void main(String[] args) {
		// super class reference = sub class object
		Employee employee = new Manager();
		// calls the overridden method from Manager
		employee.calcBonus(2000);
		employee.greet();

		Manager manager = (Manager) employee;
		manager.projectDetails();

		employee = new Developer();
		// calls the overridden method from Developer
		employee.calcBonus(2000);
	}
}
