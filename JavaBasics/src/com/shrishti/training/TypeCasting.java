package com.shrishti.training;

public class TypeCasting {

	public static void main(String[] args) {

		byte b = 100;
		int x = b * 2;	// up-casting
		System.out.println(x);  // prints 200
		long y = b ^ 2; // up-casting
		System.out.println(y);  // prints 102?
		
		float a = x + y + b;
		double num = a * 2;
		System.out.println(num);
		
		// down-casting
		
	}

}
