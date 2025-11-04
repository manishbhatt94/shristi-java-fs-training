package com.inter.extend;

public class BasicCalculator implements ICalculator {

	@Override
	public void add(int x, int y) {
		System.out.println("Sum = " + (x + y));
	}

	@Override
	public void difference(int x, int y) {
		System.out.println("Difference = " + (x - y));
	}
}
