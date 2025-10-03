package com.shrishti.arrays;

import java.util.Scanner;

public class ScanDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name: ");
		String name = sc.nextLine(); // try with nextLine
		// String name = sc.next();
		System.out.println("Name = " + name.toUpperCase());

		System.out.println("Enter ID: ");
		int empId = sc.nextInt();
		System.out.println("ID = " + empId);

		sc.nextLine();

		System.out.println("Enter city: ");
		String city = sc.nextLine();
		System.out.println("City = " + city);

		System.out.println("Enter salary: ");
		double salary = sc.nextDouble();
		System.out.println("Salary = " + salary);

		sc.close();
	}
}
