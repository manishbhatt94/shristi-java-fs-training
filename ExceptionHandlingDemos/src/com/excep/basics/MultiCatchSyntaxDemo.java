package com.excep.basics;

public class MultiCatchSyntaxDemo {

	public static void main(String[] args) {
		System.out.println("Welcome");
		try {
			String val = args[0]; // ArrayIndexOutOfBoundsException
			System.out.println("Got value: " + val);
			int num = Integer.parseInt(val); // NumberFormatException
			System.out.println("Number: " + num);
			int result = 10 / num; // ArithmeticException
			int[] marks = null;
			System.out.println(marks[0]); // NullPointerException
			System.out.println("Result: " + result);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("MultiCatch");
			System.out.println("Error occured");
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println("RuntimeException");
			System.out.println("Error occured");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("Other exception");
			System.out.println("Error occured");
			System.out.println(e);
		}
		System.out.println("Work done");
	}
}
