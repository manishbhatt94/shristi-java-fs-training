package com.lang.examples;

public class WrapperDemo {

	public static void main(String[] args) {

		Integer in1 = 10;
		Object ob1 = in1;
		String st1 = (String) ob1;

		int x = 100;
		long y = x; // up-casting
		Long a = y; // auto-boxing
		Object o = a; // up-casting of objects
		Long s1 = (Long) o; // down-casting
		long s2 = s1;

		int x1 = 200;
		Integer y1 = x1; // auto-boxing
		// Long a1 = y1; // error - Long is not an ancestor of Integer class
		// Long a1 = (Long) y1; // also error - same
		Object o1 = y1;
		// Long a1 = (Long) o1; // down-casting - but fails with ClassCastException
	}
}
