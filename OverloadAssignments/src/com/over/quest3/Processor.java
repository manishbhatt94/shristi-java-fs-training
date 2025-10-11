package com.over.quest3;

public class Processor {

	/**
	 * Prints the square root of {@code num} parameter
	 * 
	 * @param num A non negative real number
	 */
	void calculate(double num) {
		double squareRoot = Math.sqrt(num);
		System.out.println("Square root of " + num + " = " + squareRoot);
		System.out.println();
	}

	/**
	 * Prints the product of two integers {@code a} and {@code b}
	 * 
	 * @param a An integer
	 * @param b Another integer
	 */
	void calculate(int a, int b) {
		long product = (long) a * b;
		System.out.println(String.format("%d * %d = %d", a, b, product));
		System.out.println();
	}

	/**
	 * Prints the difference between two integers {@code a} and {@code b}
	 * 
	 * @param a A real number
	 * @param b Another real number
	 */
	void calculate(double a, double b) {
		double diff = a - b;
		System.out.println(String.format("%.4f - %.4f = %.4f", a, b, diff));
		System.out.println();
	}

	/**
	 * Prints the result of {@code base} raised to power of {@code exponent}
	 * 
	 * @param base     A real number
	 * @param exponent Another real number
	 */
	void calculate(double base, int exponent) {
		double power = Math.pow(base, exponent);
		System.out.println(String.format("%.4f ^ %d = %.4f", base, exponent, power));
		System.out.println();
	}

	/**
	 * Prints the square of an integer {@code num}
	 * 
	 * @param num An integer
	 */
	void calculate(int num) {
		long square = num * num;
		System.out.println(String.format("Square of %d = %d", num, square));
		System.out.println();
	}
}
