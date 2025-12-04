package dev.java.utilFunctionPackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/*
 * Variants for Specialized Function<T, R> interfaces:
 *
 * Parameter types	T					int					long					double
 * T				UnaryOperator<T>	IntFunction<T>		LongFunction<T>			DoubleFunction<T>
 * int				ToIntFunction<T>	IntUnaryOperator	LongToIntFunction		DoubleToIntFunction
 * long				ToLongFunction<T>	IntToLongFunction	LongUnaryOperator		DoubleToLongFunction
 * double			ToDoubleFunction<T>	IntToDoubleFunction	LongToDoubleFunction	DoubleUnaryOperator
 */
public class FunctionDemo {

	public static void main(String[] args) {

		Function<String, Integer> toLength = s -> s.length();
		String word = "Strawberries";
		// auto-boxing from s.length() -- i.e. int to Integer
		// then auto-unboxing when assigning to int length = toLength.apply(word);
		// from Integer to int.
		int length = toLength.apply(word);
		System.out.printf("Word '%s' length = %d chars.%n", word, length);
		System.out.println();

		// There is a special interface: UnaryOperator<T> which extends Function<T, T>.
		// This unary operator concept is used to name the functions that take an
		// argument of a given type, and return a result of the same type.

		// All the classical math operators can be modeled by a UnaryOperator<T>: the
		// square root, all the trigonometric operators, the logarithm, and the
		// exponential.
		UnaryOperator<Double> squareRoot = (number) -> Math.sqrt(number);
		System.out.printf("UnaryOperator<Double> -- squareRoot.apply(56.25) = %.2f.%n", squareRoot.apply(56.25));
		System.out.println();

		// Using specialized DoubleUnaryOperator for the same thing:
		DoubleUnaryOperator squareRoot2 = (number) -> Math.sqrt(number);
		System.out.printf("DoubleUnaryOperator -- squareRoot2.applyAsDouble(56.25) = %.2f.%n",
				squareRoot2.applyAsDouble(56.25));
		System.out.println();

		// Using specialized ToIntFunction<T> to find length of a String:
		ToIntFunction<String> toLength2 = s -> s.length();
		word = "Retrospectively";
		length = toLength2.applyAsInt(word);
		System.out.printf("ToIntFunction<String> -- toLength2.applyAsInt(\"Retrospectively\") = %d.%n", length);
		System.out.println();

		// Passing a Unary Operator to a List
		List<String> strings = Arrays.asList("one", "two", "three");
		UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
		// Interface List<E> defines the default method `replaceAll` which takes a
		// UnaryOperator<E> as parameter:
		// default void replaceAll(UnaryOperator<E> operator) { ... }
		strings.replaceAll(toUpperCase);
		System.out.println(strings);
		System.out.println();

		// Mapping Two Elements with a BiFunction
		// The interface is BiFunction<T, U, R>, where T and U are the arguments and R
		// the returned type.

		BiFunction<String, String, Integer> findWordInSentence = (sentence, wordToFind) -> sentence.indexOf(wordToFind);
		System.out.println("findWordInSentence.apply(\"Hello World\", \"World\") = "
				+ findWordInSentence.apply("Hello World", "World"));
		System.out.println();

		// Specialized BiFunction interfaces - which return primitives
		// (either int, long or double):
		// ToIntBiFunction<T, U>
		// interface ToIntBiFunction<T, U> { int applyAsInt(T t, U u); }
		// ToLongBiFunction<T, U>
		// interface ToLongBiFunction<T, U> { long applyAsLong(T t, U u); }
		// ToDoubleBiFunction<T, U>
		// interface ToDoubleBiFunction<T, U> { double applyAsDouble(T t, U u); }

		// BinaryOperator<T>
		BinaryOperator<String> hyphenate = (s1, s2) -> s1 + " - " + s2;
		System.out.printf("BinaryOperator<String> -- hyphenate.apply(\"stay\", \"hard\") = %s.%n",
				hyphenate.apply("stay", "hard"));
		System.out.println();

		// Specialized BinaryOperator interfaces - which work on primitives
		// (either int, long or double):
		// IntBinaryOperator, LongBinaryOperator, and DoubleBinaryOperator.
		// @formatter:off
		// interface IntBinaryOperator { int applyAsInt(int left, int right); }
		// interface LongBinaryOperator { long applyAsInt(long left, long right); }
		// interface DoubleBinaryOperator { double applyAsInt(double left, double right); }
		// @formatter:on

	}

}
