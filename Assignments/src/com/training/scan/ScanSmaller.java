package com.training.scan;

import java.util.Scanner;

public class ScanSmaller {

	public static void main(String[] args) {
		System.out.println("Enter 3 numbers (integers) in the below line, separated by spaces:");

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		sc.close();

		int min = Integer.MAX_VALUE;

		if (a < b && a < c) {
			min = a;
		} else if (b < a && b < c) {
			min = b;
		} else {
			min = c;
		}

		System.out.println("Smallest of the 3 numbers entered is " + min);
	}
}
