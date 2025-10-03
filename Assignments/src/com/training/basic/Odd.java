package com.training.basic;

public class Odd {

	public static void main(String[] args) {
		/* Odd numbers up to 20 */

		System.out.println("Odd numbers upto 20:");

		for (int num = 0; num <= 20; num++) {
			if (num % 2 == 1) {
				System.out.print(num + " ");
			}
		}

		System.out.println();
	}
}
