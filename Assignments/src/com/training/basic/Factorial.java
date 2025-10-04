package com.training.basic;

public class Factorial {

	public static void main(String[] args) {
		/* Print the factorial of a number */

		int num = (int) (Math.random() * 13);

		int factorial = 1;

		for (int i = 2; i <= num; i++) {
			factorial *= i;
		}

		System.out.println("Number N = " + num);
		System.out.println("Factorial of N (N!) = " + factorial);
	}
}
