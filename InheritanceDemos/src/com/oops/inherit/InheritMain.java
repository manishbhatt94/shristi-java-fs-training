package com.oops.inherit;

public class InheritMain {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.empName = "Priya";
		employee.empId = 1;
		employee.getDetails();

		Manager manager = new Manager();
		manager.empName = "Sri";
		manager.empId = 2;
		manager.salary = 1000;
		manager.getDetails();
		manager.calcBonus(1000);
	}
}
