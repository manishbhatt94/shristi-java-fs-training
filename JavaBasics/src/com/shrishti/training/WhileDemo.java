package com.shrishti.training;

public class WhileDemo {

	public static void main(String[] args) {
		int x = 0;
		while (x < 5) {
			System.out.println(x);
			x++;
		}
		
		System.out.println();
		
		do {
			System.out.println(x);
			x++;
		} while (x < 10);
	}
}
