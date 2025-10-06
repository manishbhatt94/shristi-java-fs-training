package com.training.scan;

import java.util.Scanner;

public class ScanGreater {

	public static void main(String[] args) {
		System.out.println("Enter 3 numbers (integers) in the below line, separated by spaces:");

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		sc.close();

		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);

		System.out.println("Greatest of the 3 numbers entered is " + max);
	}
}
