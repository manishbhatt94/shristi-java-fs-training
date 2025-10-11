package com.over.quest1;

import java.util.Scanner;

public class OverloadMain {

	public static void main(String[] args) {
		Employee[] employees = OverloadMain.readEmployees(2);
		OverloadMain.printBonuses(employees);
	}

	private static Employee[] readEmployees(int employeesCount) {
		System.out.println("Enter details of " + employeesCount + " employees (when prompted below)");
		Employee[] employees = new Employee[employeesCount];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < employeesCount; i++) {
			System.out.println("\nEnter details (name & designation) for Employee #" + (i + 1));
			System.out.println("Enter name for Employee #" + (i + 1) + ":");
			String name = sc.nextLine();
			String designation = "";
			do {
				System.out.println("Enter designation " + "(choose from 'Manager' / 'Programmer' / 'Director')"
						+ "for Employee #" + (i + 1) + ":");
				designation = sc.nextLine();
			} while (!Employee.validDesignations.contains(designation.toLowerCase()));

			employees[i] = new Employee(name, designation);
		}

		sc.close();
		return employees;
	}

	private static void printBonuses(Employee[] employees) {
		System.out.println("\nPrinting current bonus information for " + employees.length + " employees:");

		for (Employee emp : employees) {
			System.out.println("\nGetting bonus details for Employee:");
			emp.printInfo();

			switch (emp.designation.toLowerCase()) {
			case "programmer":
				emp.calcBonus(30_000.0);
				break;
			case "manager":
				emp.calcBonus(45_000.0, "2 Tickets to any movie");
				break;
			case "director":
				emp.calcBonus(90_000.0, "A day's stay in any local resort, for two guests");
				break;
			default:
				System.out.println("Invalid designation. Something went wrong!");
				break;
			}
		}
	}
}
