package com.training.basic;

import java.util.HashMap;
import java.util.Map;

public class Duplicates {

	public static void main(String[] args) {
		Duplicates obj = new Duplicates();
		int[] nums = obj.getRandomArray(10);
		Map<Integer, Integer> freqMap = obj.countDuplicates(nums);

		boolean noDuplicates = true;

		System.out.println("Finding duplicates in the array...");

		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			Integer item = entry.getKey();
			Integer freq = entry.getValue();
			if (freq > 1) {
				noDuplicates = false;
				System.out.print(item + " ");
			}
		}
		if (noDuplicates) {
			System.out.println("No duplicates found!");
		} else {
			System.out.println();
		}
	}

	private Map<Integer, Integer> countDuplicates(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int val : nums) {
			if (freq.containsKey(val)) {
				freq.put(val, freq.get(val) + 1);
			} else {
				freq.put(val, 1);
			}
		}
		return freq;
	}

	private int[] getRandomArray(int size) {
		// initialize array with 'size' number of elements
		int[] nums = new int[size];

		// populate it with random numbers (up-to 100), while printing it
		System.out.println("Array:");
		for (int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 8);
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		// return it
		return nums;
	}
}
