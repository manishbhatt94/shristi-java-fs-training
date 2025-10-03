package com.shrishti.arrays;

public class TwoDimArr {

	public static void main(String[] args) {
		int[][] nums = new int[3][4];
		
		nums[0][0] = 0;
		nums[0][1] = 1;
		nums[0][2] = 2;
		nums[0][3] = 3;

		nums[1][0] = 4;
		nums[1][1] = 5;
		nums[1][2] = 6;
		nums[1][3] = 7;
		
		nums[2][0] = 8;
		nums[2][1] = 9;
		nums[2][2] = 10;
		nums[2][3] = 11;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		
		
		// Compute sum of all elements in the 2D array
		System.out.println();
		int sum = 0;
		
		for (int[] row: nums) {
			for (int val: row) {
				sum += val;
			}
		}
		
		System.out.println("Sum = " + sum);
	}
}
