package com.training.basic;

public class PatternSame {

	public static void main(String[] args) {
		int rows = 9;

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
