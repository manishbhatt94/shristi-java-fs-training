package com.abs.quest1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DemoAbs {

	public static void main(String[] args) {
		DemoAbs.onboardEmployee();
	}

	private static void onboardEmployee() {
		Scanner sc = new Scanner(System.in);

		// read employee type
		String employeeType = null;
		do {
			if (employeeType != null) {
				System.out.println("Invalid employee type entered. Please try again:");
			}
			System.out.println("Enter new employee type ('manager' / 'developer' / 'teamlead'):");
			employeeType = sc.nextLine().trim().toLowerCase();
		} while (!Employee.validDesignations.contains(employeeType));

		// read employee basic details
		System.out.println("\nEnter employee basic details, as prompted:");
		System.out.println("Enter employee's name:");
		String empName = sc.nextLine();
		System.out.println("Enter name of employee's company:");
		String empCompany = sc.nextLine();
		System.out.println("Enter employee's salary:");
		double salary = sc.nextDouble();
		sc.nextLine(); // flushing scanner newline
		int empId = new Random().nextInt(10000);

		Employee employee;

		switch (employeeType) {
		case "manager":
			System.out.println("Enter next team bonding activity planned from manager's team budget:");
			String managerActivity = sc.nextLine();
			employee = new Manager(empName, empId, salary, empCompany, managerActivity);
			DemoAbs.callEmployeeMethods(employee);
			Manager manager = (Manager) employee;
			System.out.println("\nManager planned team bonding activity:");
			manager.funClub();
			break;

		case "teamlead":
			employee = new Developer(empName, empId, salary, empCompany);
			DemoAbs.callEmployeeMethods(employee);
			TeamLead lead = (TeamLead) employee;
			System.out.println("\nTeam Lead offering corporate services:");
			lead.corporateServices();
			break;

		case "developer":
			employee = new Developer(empName, empId, salary, empCompany);
			DemoAbs.callEmployeeMethods(employee);
			Developer developer = (Developer) employee;
			System.out.println("\nDeveloper hobbies:");
			developer.showHobbies();
			break;

		default:
			System.out.println("Unreachable code segment");
			System.exit(1);
		}

		System.out.println("\nEnd of program run!");

		sc.close();
	}

	private static void callEmployeeMethods(Employee employee) {
		System.out.println("\nPrinting employee details:");
		employee.printDetails();

		System.out.println("\nRules for employees:");
		employee.showRules();

		System.out.println("\nMandatory courses that all employees need to take:");
		String[] courses = employee.showCourses();
		System.out.println(Arrays.toString(courses));

		System.out.println("\nEmployee bonus based on salary:");
		employee.calcBonus(employee.salary);

		System.out.println("\nProjects that the employee is working on:");
		employee.showProjects();
	}
}
