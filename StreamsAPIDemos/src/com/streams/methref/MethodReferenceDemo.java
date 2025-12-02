package com.streams.methref;

public class MethodReferenceDemo {

	public static void main(String[] args) {

		// Using Lambda
		ICalculator calc1 = (u, v) -> System.out.println("Sum -> " + (u + v));
		calc1.add(3, 5);

		// Using method reference of a static method
		ICalculator calc2 = Operations::sum;
		calc2.add(12, 21);

		// Using method reference of an instance (non-static) method
		Operations operations = new Operations();
		IGreeter greeter = operations::greet;
		System.out.println(greeter.welcomeUser("batman"));

	}

}
