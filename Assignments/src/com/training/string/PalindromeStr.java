package com.training.string;

import java.util.Scanner;

public class PalindromeStr {

	public static void main(String[] args) {
		/**
		 * Create a program to find if the string is a Palindrome or not
		 */
		System.out.println("Enter a string (to test for palindrome property):");

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		PalindromeStr obj = new PalindromeStr();

		if (obj.isPalindrome(str)) {
			System.out.println("Input string is a Palindrome");
		} else {
			System.out.println("Input string is NOT a Palindrome");
		}
	}

	private boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}
}
