package com.inter.lamb;

public class LambdaDemo {

	public static void main(String[] args) {
		// implementation () -> {}
		ICalculator ref = (int x, int y) -> {
			System.out.println("Sum = " + (x + y));
		};
		// calling
		ref.calculate(10, 20);

		ref = (x, y) -> System.out.println("Product = " + (x * y));
		ref.calculate(8, 5);

		IGreeter greeter = uname -> {
			if (uname.equals("Priya")) {
				return "Hello " + uname;
			} else {
				return "Wrong user";
			}
		};
		System.out.println(greeter.greet("Priya"));
		System.out.println(greeter.greet("Ravi"));

		IGreeter greeter1 = str -> "Welcome " + str;
		System.out.println(greeter1.greet("Manish"));
	}
}
