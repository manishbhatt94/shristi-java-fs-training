package com.training.basic;

public class Sum {

	public static void main(String[] args) {
		/* Print the sum and average of all numbers in an array */

		// initialize & populate array, also print it
		int[] nums = new int[10];

		System.out.println("Array:");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100);
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		// compute sum & average
		int sum = 0;
		
		for (int val: nums) {
			sum += val;
		}
		
		double average = (double) sum / nums.length;
		
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
	}
}
