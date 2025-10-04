package com.training.basic;

public class PatternDiff {

	public static void main(String[] args) {
		int rows = 4;
		int current = 1;

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(current++ % 10);
			}
			System.out.println();
		}
	}
}
