package com.inter.lamb;

public class AnonyDemo {

	public static void main(String[] args) {
		ICalculator ref = new Addition();
		ref.calculate(10, 20);

		// anonymous inner class
		ICalculator ref1 = new ICalculator() {

			@Override
			public void calculate(int x, int y) {
				System.out.println("Product = " + (x * y));
			}

//			@Override
//			public void square(int x) {
//				System.out.println("Square = " + (x * x));
//			}
		};

		ref1.calculate(5, 25);
		// ref1.square(6);
	}
}
