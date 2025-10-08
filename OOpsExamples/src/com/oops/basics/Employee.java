package com.oops.basics;

public class Employee {

	String empName;
	int empId;
	double salary;

	public static void main(String[] args) {
		Employee emp = new Employee();
		// print without initializing instance variables
		// so they have will the default values according to their respective data types
		System.out.println(emp.empName + " " + emp.empId + " " + emp.salary);

		// assign values
		emp.empName = "Manish";
		emp.empId = 1;
		emp.salary = 2000;
		System.out.println(emp.empName + " " + emp.empId + " " + emp.salary);

		Employee emp1 = new Employee();
		emp1.empName = "Kamal";
		emp1.empId = 2;
		emp1.salary = 2500;
		System.out.println(emp1.empName + " " + emp1.empId + " " + emp1.salary);

		Employee emp2 = new Employee();
		emp2.empName = "Ravi";
		emp2.empId = 3;
		emp2.salary = 2500;
		System.out.println(emp2.empName + " " + emp2.empId + " " + emp2.salary);

		emp2 = emp1;
		System.out.println(emp2.empName + " " + emp1.empName);
		emp1.empName = "Raj";
		System.out.println(emp2.empName + " " + emp1.empName);

		emp1 = null;
		System.out.println(emp2.empName);
		// System.out.println(emp1.empName); // throws NPE

		System.out.println("hello"); // not executed coz of exception in previous line
	}
}
