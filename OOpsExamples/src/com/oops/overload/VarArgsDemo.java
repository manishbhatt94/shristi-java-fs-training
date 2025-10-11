package com.oops.overload;

public class VarArgsDemo {

	public static void main(String[] args) {
		VarArgsDemo demo = new VarArgsDemo();
		demo.calcSum("Raju");
		demo.calcSum("Ravi", 90, 80);
	}

	void calcSum(String name, int... marks) {
		System.out.println("\nWelcome: " + name);
		System.out.println("Calculating sum of " + marks.length + " subjects for " + name);

		int sum = 0;

		for (int mark : marks) {
			sum += mark;
		}

		System.out.println("Sum of marks = " + sum);
	}
	
	void calcSum(String name) {
		System.out.println("Hello " + name);
	}
}
