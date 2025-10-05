package com.training.basic;

public class Reverse {

	public static void main(String[] args) {
		/* Program to reverse an integer number */
		int num = (int) (Math.random() * 1000);
		System.out.println("Number: " + num);

		Reverse obj = new Reverse();

		int reversedNum = obj.reverse(num);
		System.out.println("Reversed number: " + reversedNum);
	}

	private int reverse(int num) {
		int n = num;
		int rev = 0;

		while (n > 0) {
			int lastDigit = n % 10;
			rev = rev * 10 + lastDigit;
			n = n / 10;
		}

		return rev;
	}
}
