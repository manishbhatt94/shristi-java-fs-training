package com.shrishti.arrays;

public class CmdDemo {

	public static void main(String[] args) {
		String name = args[0];
		System.out.println("Name: " + name);
		
		int empId = Integer.parseInt(args[1]);
		System.out.println("Id: " + empId);
		
		double salary = Double.parseDouble(args[2]);
		System.out.println("Salary: " + salary);
	}
}
