package com.oops.stat;

public class StaticBlockDemo {

	static int x;
	static int y = 100;
	
	static {
		System.out.println("In static block");
		x = 30;
		System.out.println(x + y);
	}
	
	public StaticBlockDemo() {
		System.out.println("Great - default constructor");
	}
	
	static void call() {
		System.out.println("Helloo.. from call() static method");
	}
}
