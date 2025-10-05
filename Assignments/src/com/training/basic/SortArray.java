package com.training.basic;

public class SortArray {

	public static void main(String[] args) {
		/* Manually sort an integer array in ascending order */
		SortArray obj = new SortArray();

		int nums[] = obj.getRandomArray(6);

		// sorting the array in ascending order using Selection Sort algorithm
		System.out.println("Sorting...");
		obj.selectionSort(nums);

		// printing resultant array
		System.out.println("Resultant array:");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	private void selectionSort(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < nums[i]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
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
