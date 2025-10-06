package com.training.scan;

import java.util.Arrays;
import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot obj = new SquareRoot();

		int[] nums = obj.readNumbersArray();

		double[] roots = new double[nums.length];

		for (int i = 0; i < nums.length; i++) {
			roots[i] = Math.sqrt(nums[i]);
		}

		System.out.println("\nSquare roots of the array elements:");
		System.out.println(Arrays.toString(roots));
	}

	private int[] readNumbersArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int arraySize = scanner.nextInt();

		int[] numbers = new int[arraySize];

		System.out.println("Enter " + arraySize + " integer values:");
		for (int i = 0; i < arraySize; i++) {
			System.out.print("Enter value for element " + (i + 1) + ": ");
			numbers[i] = scanner.nextInt();
		}

		scanner.close();

		System.out.println("\nArray elements:");
		System.out.println(Arrays.toString(numbers));

		return numbers;
	}
}
