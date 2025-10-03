package com.training.basic;

public class Greater {

	public static void main(String[] args) {
		/* Greatest in an array */

		// initialize & populate array, also print it
		int[] nums = new int[10];

		System.out.println("Array:");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		// find greatest
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		// print result
		System.out.println("Greatest: " + max);
	}
}
