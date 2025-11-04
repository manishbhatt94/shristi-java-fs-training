package com.inter.extend;

public class CalcMain {

	public static void main(String[] args) {
		System.out.println("Using Basic Calculator");
		ICalculator calculator = new BasicCalculator();
		calculator.add(10, 20);
		calculator.difference(45, 60);
		System.out.println();

		System.out.println("Using Scientific Calculator");
		IScientific scientific = new ScientificCalculator();
		scientific.add(98, 22);
		scientific.difference(6, 46);
		scientific.square(5);
		scientific.cube(4);
		System.out.println();
	}
}
