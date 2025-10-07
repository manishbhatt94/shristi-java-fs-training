package com.training.string;

import java.util.Scanner;

public class MaxOccuringLetter {

	public static void main(String[] args) {
		/**
		 * Create a program to find out the maximum occurrence of a letter in a word.
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an English word: ");
		String word = sc.next();

		sc.close();

		String normalisedWord = word.trim().toLowerCase();

		// build a letter frequency map - using an int array with 26 slots
		// for this - since English has 26 letters
		int[] freqMap = new int[26];

		for (int i = 0; i < normalisedWord.length(); i++) {
			char ch = normalisedWord.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				freqMap[ch - 'a']++;
			}
		}

		// find the letter with the max frequency
		int maxFreq = 0;
		char mostFreqLetter = '\0';
		for (int i = 0; i < freqMap.length; i++) {
			if (freqMap[i] > maxFreq) {
				maxFreq = freqMap[i];
				mostFreqLetter = (char) ('a' + i);
			}
		}

		if (maxFreq > 0) {
			System.out.println(String.format("Letter '%c' occurred most frequently in \"%s\" (total of %d times)",
					mostFreqLetter, word, maxFreq));
		} else {
			System.out.println("English letters were not found in input word. Try next time!");
		}
	}
}
