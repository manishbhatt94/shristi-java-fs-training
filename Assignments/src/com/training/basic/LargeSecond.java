package com.training.basic;

public class LargeSecond {

	public static void main(String[] args) {
		/* Second largest in an array */

		// initialize & populate array, also print it
		int[] nums = new int[10];

		System.out.println("Array:");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		// find largest, and second largest
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int val : nums) {
			if (val > largest) {
				secondLargest = largest;
				largest = val;
			} else if (val < largest && val > secondLargest) {
				secondLargest = val;
			}
		}

		System.out.println("Largest: " + largest);
		System.out.println("Second Largest: " + secondLargest);
	}
}
