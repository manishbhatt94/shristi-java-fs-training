package com.shrishti.training;

public class TernaryOperator {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 1000);
		int b = (int) (Math.random() * 1000);
		int c = (int) (Math.random() * 1000);

		System.out.println(String.format("Three random numbers: %d %d %d", a, b, c));

		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		
		System.out.println("Max of the numbers: " + max);
	}
}
