package com.shrishti.training;

public class IncrementDecrement {

	public static void main(String[] args) {
		int x = 10;
		int y = 1;
		int z = 5;

		int a = ++x + y++ + z;
		int b = ++a + ++y + z--;
		int c = a + b + ++x + y++;
		int d = ++z + ++y + x++;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}

}
