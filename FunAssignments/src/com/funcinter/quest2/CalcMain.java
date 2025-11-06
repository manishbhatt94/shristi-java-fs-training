package com.funcinter.quest2;

public class CalcMain {

	public static void main(String[] args) {
		System.out.println("Various math calculations:\n\n");

		ICalculator calculator = null;

		// sum
		calculator = (x, y) -> {
			double result = x + y;
			System.out.printf("Sum (%.2f + %.2f) = %.2f\n\n", x, y, result);
		};
		calculator.calculate(10, 20);

		// product
		calculator = (x, y) -> {
			double result = x * y;
			System.out.printf("Product (%.2f * %.2f) = %.2f\n\n", x, y, result);
		};
		calculator.calculate(15, 5);

		// power
		calculator = (x, y) -> {
			double result = Math.pow(x, y);
			System.out.printf("Power (%.2f ^ %.2f) = %.2f\n\n", x, y, result);
		};
		calculator.calculate(7, 3);

		// hypotenuse
		calculator = (x, y) -> {
			double result = Math.sqrt(x * 2 + y * 2);
			System.out.printf("Hypotenuse (%.2f, %.2f) = %.2f\n\n", x, y, result);
		};
		calculator.calculate(3, 4);
	}
}
