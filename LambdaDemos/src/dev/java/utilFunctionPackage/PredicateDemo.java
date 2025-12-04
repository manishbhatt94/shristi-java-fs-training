package dev.java.utilFunctionPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		Predicate<String> length3 = s -> s.length() == 3;
		System.out.println("Is \"cat\" of length 3? -> " + length3.test("cat"));
		System.out.println("Is \"cattle\" of length 3? -> " + length3.test("cattle"));
		System.out.println();

		// Specialized Predicate's for 'testing' primitive values - we have three
		// options to chooose from:
		// IntPredicate, LongPredicate and DoublePredicate.
		IntPredicate isGreaterThan10 = i -> i > 10;
		System.out.println("32 isGreaterThan10? -> " + isGreaterThan10.test(32));
		System.out.println("7 isGreaterThan10? -> " + isGreaterThan10.test(7));
		System.out.println();

		// Testing Two Elements with a BiPredicate<T, U>
		BiPredicate<String, Integer> isOfLength = (word, length) -> word.length() == length;
		String word = "Orange"; // really any word will do!
		int length = 6;
		boolean isWordOfLength3 = isOfLength.test(word, length);
		System.out.printf("Is the word '%s' of length %d characters? -> %B.%n", word, length, isWordOfLength3);
		System.out.println();

		// Passing a Predicate to a Collection.
		// Collection<E> interface implements a `removeIf(Predicate)` since JDK 1.8:
		// default boolean removeIf(Predicate<? super E> filter) { ... }
		// Removes all of the elements of this collection that satisfy the given
		// predicate.
		List<String> immutableStrings = List.of("one", "two", "three", "four", "five");
		List<String> strings = new ArrayList<>(immutableStrings);
		Predicate<String> isEvenLength = s -> s.length() % 2 == 0;
		strings.removeIf(isEvenLength);
		System.out.println("strings = " + strings);
		System.out.println();

	}

}
