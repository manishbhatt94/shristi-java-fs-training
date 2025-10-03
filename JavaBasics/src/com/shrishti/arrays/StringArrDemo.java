package com.shrishti.arrays;

public class StringArrDemo {

	public static void main(String[] args) {
		// Create a String array containing 3 names
		// Write a loop to print all names in uppercase
		
		String[] names = new String[3];
		names[0] = "Kamal";
		names[1] = "Manish";
		names[2] = "Ravi";
		
		// looping to print all names
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i].toUpperCase());
		}
	}
}
