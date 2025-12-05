package dev.java.lambdasAsMethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Method Reference syntax & their Lambda equivalent syntax:
 * (For Constructor Method References)
 *
 * @formatter:off
 * Name			Syntax				Lambda equivalent
 * Constructor	ClassName::new		(args) -> new ClassName(args)
 * @formatter:on
 */

public class Demo4ConstructorMethRef {

	public static void main(String[] args) {

		// Examples of using Constructor Method Reference syntax
		// for referring to constructor instead of writing
		// a lambda that wraps calls to that constructor.

		// 1. Referring to Default Constructor (zero-args constructor).
		// 2. Referring to Parameterized Constructor.
		// For both, same syntax of `ClassName::new` is used for method reference to the
		// constructor.

		// 1. Referring to Default Constructor (zero-args constructor):
		System.out.println("1. Referring to Default Constructor (zero-args constructor):");

		// Using lambda expression that wraps call to the default constructor
		Supplier<List<String>> newListOfStringsLambda = () -> new ArrayList<>();
		List<String> list1 = newListOfStringsLambda.get();
		System.out.println("list1 (lamda) = " + list1);

		// Using constructor method reference that refers to the default constructor

		// Skipping diamond is also valid:
		// i.e. ArrayList::new is a valid constructor method reference.
		// Supplier<List<String>> newListOfStrings = ArrayList::new;

		// If providing diamond, then need to include the generic type within the
		// diamond:
		// i.e. `ArrayList<String>::new` is a valid constructor method reference.
		// But `ArrayList<>::new` (i.e. with empty diamond) is NOT a valid constructor
		// method reference, and will give compile-time syntax (parsing) error.
		Supplier<List<String>> newListOfStrings = ArrayList<String>::new;

		List<String> list2 = newListOfStrings.get();
		System.out.println("list2 (meth-ref) = " + list2);

		System.out.println();

		// =================================================================

		// 2. Referring to Parameterized Constructor:

		System.out.println("2. Referring to Parameterized Constructor:");

		// Using lambda expression that wraps call to the parameterized constructor
		Function<Integer, List<String>> newListOfNStringsLambda = size -> new ArrayList<>(size);
		List<String> list3 = newListOfNStringsLambda.apply(5);
		System.out.println("list3 (lamda) = " + list3);

		// Using constructor method reference that refers to the parameterized
		// constructor
		Function<Integer, List<String>> newListOfNStrings = ArrayList::new;
		List<String> list4 = newListOfNStrings.apply(5);
		System.out.println("list4 (meth-ref) = " + list4);

		System.out.println();

		// =================================================================

	}

}
