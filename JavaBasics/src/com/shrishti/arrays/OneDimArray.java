package com.shrishti.arrays;

public class OneDimArray {

	public static void main(String[] args) {
		// int x = 10;
		// int y;
		// local variables should be initialized before use
		// System.out.println(x + y);

		int[] nums = new int[4];
		// just printing an array will only print the particular array's hash-code
		System.out.println(nums);

		System.out.println(nums.length);

		nums[0] = 90;
		nums[1] = 80;
		nums[2] = 40;
		nums[3] = 50;
		// nums[4] = 60; // ArrayIndexOutOfBoundsException

		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println("sum(nums[]) = " + sum);
		
		// using for each loop, print the square of each element
		for (int val : nums) {
			System.out.println(val + "^2 = " + val * val);
		}
	}
}
