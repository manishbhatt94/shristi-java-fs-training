package com.training.basic;

public class Fibonacci {

	public static void main(String[] args) {
		/* Print the first 'N' terms of the Fibonacci series */
		int nterms = 4; // number of terms required
		
		System.out.println("The first " + nterms + " terms of the Fibonacci series:");
		
		System.out.print("0 1 ");
		
		nterms -= 2;
		
		int a = 0;
		int b = 1;
		int c;
		
		while (nterms > 0) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
			nterms--;
		}
		
		System.out.println();
	}
}
