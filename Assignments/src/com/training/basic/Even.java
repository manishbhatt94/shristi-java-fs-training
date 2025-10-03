package com.training.basic;

public class Even {

	public static void main(String[] args) {
		/* Even numbers up to 20 */

		System.out.println("Even numbers upto 20:");

		for (int num = 0; num <= 20; num++) {
			if (num % 2 == 0) {
				System.out.print(num + " ");
			}
		}

		System.out.println();
	}
}
