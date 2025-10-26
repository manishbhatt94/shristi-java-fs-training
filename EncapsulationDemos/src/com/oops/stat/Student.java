package com.oops.stat;

public class Student {

	static String collegeName;
	static int subjects;
	
	static {
		System.out.println("Static Block 1");
		subjects = 5;
	}
	
	static {
		System.out.println("Static Block 2");
		collegeName = "MVJ College";
		System.out.println(collegeName);
	}
	
	static void printMessage() {
		System.out.println("Great Day - from printMessage() static method");
	}
	
	static void call() {
		System.out.println("Just a static member - call() method");
	}
}
