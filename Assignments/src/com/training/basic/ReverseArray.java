package com.training.basic;

public class ReverseArray {

	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();

		int nums[] = obj.getRandomArray(10);

		// reversing each element of the array
		System.out.println("Reversing all array elements...");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = obj.reverse(nums[i]);
		}

		// printing resultant array
		System.out.println("Resultant array:");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	private int reverse(int num) {
		int n = num;
		int rev = 0;

		while (n > 0) {
			int lastDigit = n % 10;
			rev = rev * 10 + lastDigit;
			n = n / 10;
		}

		return rev;
	}

	private int[] getRandomArray(int size) {
		// initialize array with 'size' number of elements
		int[] nums = new int[size];

		// populate it with random numbers (up-to 100), while printing it
		System.out.println("Array:");
		for (int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 100);
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		// return it
		return nums;
	}
}
