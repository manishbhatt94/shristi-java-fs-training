package dev.java.lambdasAsMethodReferences;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Method Reference syntax & their Lambda equivalent syntax:
 * (For Bound Method References)
 *
 * @formatter:off
 * Name		Syntax					Lambda equivalent
 * Bound	expr::instanceMethod	(args) -> expr.instanceMethod(args)
 * @formatter:on
 */

public class Demo3BoundMethRef {

	public static void main(String[] args) {

		// Examples of using Bound Method Reference syntax
		// for referring to existing instance methods instead of writing
		// a lambda that wraps calls to that method.

		// 1. Classic example: referring to println method:
		// Which is accessed using `System.out` object - which is
		// an object of PrintStream class.
		System.out.println("1. Classic example: referring to println method:");

		// Using lambda expression that wraps call to original method
		Consumer<String> printerLambda = s -> System.out.println(s);
		System.out.println("printer(\"wonderland\") (lamda) = ");
		printerLambda.accept("wonderland");

		// Using bound method reference that refers to original method
		Consumer<String> printer = System.out::println;
		System.out.println("printer(\"wonderland\") (meth-ref) = ");
		printer.accept("wonderland");

		// This method reference is called bound because the object on which the method
		// is called is defined in the method reference itself. So this call is bound to
		// the object given in the method reference.

		System.out.println();

		// =================================================================

		// 2. Example with a Java Bean class:

		System.out.println("2. Example with a Java Bean class:");
		final User vegeta = new User("depressed.vegeta.19", 23);

		// Using lambda expression that wraps call to original method
		Supplier<String> getVegetasUserNameLambda = () -> vegeta.getName();
		String userName = getVegetasUserNameLambda.get();
		System.out.println("getVegetasUserName() (lamda) = " + userName);

		// Using bound method reference that refers to original method
		Supplier<String> getVegetasUserName = vegeta::getName;
		userName = getVegetasUserName.get();
		System.out.println("getVegetasUserName() (meth-ref) = " + userName);

		System.out.println();

		// =================================================================

	}

}
