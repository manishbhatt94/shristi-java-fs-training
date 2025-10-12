package com.oops.overload;

public class ThisDemo {

	public ThisDemo() {
		this(10);
		System.out.println("hello");
	}

	public ThisDemo(String name) {
		System.out.println("welcome " + name);
	}

	public ThisDemo(int x) {
		this("Priya");
		System.out.println("val " + x);
	}

	public void greet() {
		System.out.println("dummy greeting");
	}

	public static void main(String[] args) {
		ThisDemo demo = new ThisDemo();
		demo.greet();
	}
}
