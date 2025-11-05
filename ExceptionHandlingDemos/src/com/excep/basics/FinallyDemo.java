package com.excep.basics;

public class FinallyDemo {

	public static void main(String[] args) {
		System.out.println("Welcome");
		try {
			String val = "0";
			System.out.println("Got value: " + val);
			int num = Integer.parseInt(val); // NumberFormatException
			System.out.println("Number: " + num);
			int result = 10 / num; // ArithmeticException
			System.out.println("Result: " + result);
//		} catch (Exception e) {
//			System.out.println("Error occured");
//			System.out.println(e);
		} finally {
			System.out.println("Releasing the resources");
			System.out.println("Closing the database");
		}
		System.out.println("Work done");
	}
}
