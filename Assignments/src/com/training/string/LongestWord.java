package com.training.string;

import java.util.Scanner;

public class LongestWord {

	public static void main(String[] args) {
		/**
		 * Create a program to find the longest word in a sentence.
		 */
		System.out.println("Enter a sentence:");

		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();

		String[] words = sentence.split("\\s+");

		String longest = "";
		int maxLen = 0;

		for (String word : words) {
			if (word.length() > maxLen) {
				maxLen = word.length();
				longest = word;
			}
		}

		System.out.println("\nLongest word in the above sentence:");
		System.out.println(String.format("% (%d characters)", longest, maxLen));

		sc.close();
	}
}
