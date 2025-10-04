package com.training.basic;

public class DownPyramid {

	public static void main(String[] args) {
		int maxchars = 9;
		char symbol = 'M';

		int height = (int) Math.ceil(maxchars / 2.0);

		for (int i = height; i >= 1; i--) {
			// print spaces
			for (int j = 1; j <= (height - i); j++) {
				System.out.print(" ");
			}
			// print symbol
			int charsPerRow = maxchars % 2 == 0 ? 2 * i : 2 * i - 1;
			for (int j = 1; j <= charsPerRow; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
}
