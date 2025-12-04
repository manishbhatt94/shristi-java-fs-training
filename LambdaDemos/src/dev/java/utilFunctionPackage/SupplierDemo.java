package dev.java.utilFunctionPackage;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {

		Supplier<String> simpleSupplier = () -> "Hello Duke!";
		System.out.println(simpleSupplier.get());
		System.out.println();

		// random.nextInt(bound) returns an int value
		// Supplier<Integer> get() method returns the wrapper class object
		// for the int received via the lambda. This involves auto-boxing.
		// We may assign the return of supplier.get() to an int variable.
		// This involves auto-unboxing.
		// This conversion b/w wrapper & primitives - doesn't come for free.
		Random random1 = new Random(314L);
		Supplier<Integer> newRandom = () -> random1.nextInt(10);
		for (int i = 0; i < 5; i++) {
			IO.print(newRandom.get() + " ");
		}
		IO.println();

		// Specialized Suppliers for getting primitive types
		// JDK provides four (4) specialized Supplier functional interfaces
		// for dealing with primitive values:
		// IntSupplier, BooleanSupplier, LongSupplier and DoubleSupplier.
		// Which have the following functional methods (which the lambda's implement):
		// int getAsInt(), boolean getAsBoolean(), long getAsLong(),
		// double getAsDouble() respectively.
		Random random2 = new Random(314L);
		IntSupplier newRandomSp = () -> random2.nextInt(10);
		for (int i = 0; i < 5; i++) {
			System.out.print(newRandomSp.getAsInt() + " ");
		}
		System.out.println();

	}

}
