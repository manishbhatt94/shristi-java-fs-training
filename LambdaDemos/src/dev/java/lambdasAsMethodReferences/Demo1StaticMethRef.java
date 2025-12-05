package dev.java.lambdasAsMethodReferences;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongSupplier;

/**
 * Method Reference syntax & their Lambda equivalent syntax:
 * (For Static Method References)
 *
 * @formatter:off
 * Name		Syntax					Lambda equivalent
 * Static	RefType::staticMethod	(args) -> RefType.staticMethod(args)
 * @formatter:on
 */

public class Demo1StaticMethRef {

	public static void main(String[] args) {

		// Examples of using Static Method Reference syntax
		// for referring to existing various static methods
		// instead of writing a lambda that wraps calls to
		// the static method.

		// 1. Static methods that accept zero params:
		System.out.println("1. Static methods that accept zero params:");

		// Using lambda expression that wraps call to original method
		LongSupplier currTimeMillisLambda = () -> System.currentTimeMillis();
		System.out.println("currentTimeMillis (lamda) = " + currTimeMillisLambda.getAsLong());

		// Using static method reference that refers to original method
		LongSupplier currTimeMillis = System::currentTimeMillis;
		System.out.println("currentTimeMillis (meth-ref) = " + currTimeMillis.getAsLong());

		System.out.println();

		// =================================================================

		// 2. Static methods that accept one param:
		System.out.println("2. Static methods that accept one param:");

		// Using lambda expression that wraps call to original method
		DoubleUnaryOperator sqRootLambda = a -> Math.sqrt(a);
		System.out.println("sqRoot(6.25) (lamda) = " + sqRootLambda.applyAsDouble(6.25));

		// Using static method reference that refers to original method
		DoubleUnaryOperator sqRoot = Math::sqrt;
		System.out.println("sqRoot(6.25) (meth-ref) = " + sqRoot.applyAsDouble(6.25));

		System.out.println();

		// =================================================================

		// 3. Static methods that accept more than one params (two, in this example):
		System.out.println("3. Static methods that accept more than one params (two, in this example):");

		// Using lambda expression that wraps call to original method
		IntBinaryOperator getMaxLambda = (a, b) -> Integer.max(a, b);
		System.out.println("getMax(25, 19) (lamda) = " + getMaxLambda.applyAsInt(25, 19));

		// Using static method reference that refers to original method
		IntBinaryOperator getMax = Integer::max;
		System.out.println("getMax(25, 19) (meth-ref) = " + getMax.applyAsInt(25, 19));

		System.out.println();

	}

}
