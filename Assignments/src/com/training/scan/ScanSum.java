package com.training.scan;

import java.util.Arrays;
import java.util.Scanner;

public class ScanSum {
	public static void main(String[] args) {
		ScanSum obj = new ScanSum();

		int[] nums = obj.readNumbersArray();

		// computing sum &
		int sum = 0;

		for (int val : nums) {
			sum += val;
		}

		double average = (double) sum / nums.length;

		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
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
