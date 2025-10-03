package com.training.basic;

public class SmallSecond {

	public static void main(String[] args) {
		/* Second smallest in an array */

		// initialize & populate array, also print it
		int[] nums = new int[10];

		System.out.println("Array:");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		// find smallest, and second smallest
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int val : nums) {
			if (val < smallest) {
				secondSmallest = smallest;
				smallest = val;
			} else if (val > smallest && val < secondSmallest) {
				secondSmallest = val;
			}
		}

		System.out.println("Smallest: " + smallest);
		System.out.println("Second Smallest: " + secondSmallest);
	}
}
