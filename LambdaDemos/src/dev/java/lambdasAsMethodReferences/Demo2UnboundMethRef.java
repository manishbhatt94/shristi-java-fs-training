package dev.java.lambdasAsMethodReferences;

import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

/**
 * Method Reference syntax & their Lambda equivalent syntax:
 * (For Unbound Method References)
 *
 * @formatter:off
 * Name		Syntax						Lambda equivalent
 * Unbound	RefType::instanceMethod		(arg0, rest) -> arg0.instanceMethod(rest)
 * @formatter:on
 */

public class Demo2UnboundMethRef {

	public static void main(String[] args) {

		// Examples of using Unbound Method Reference syntax
		// for referring to existing instance methods instead of writing
		// a lambda that wraps calls to that method.

		// They are called unbound because these method references
		// are not bound to a particular instance (object) of the class.

		// 1. Instance methods that accept zero params:

		System.out.println("1. Instance methods that accept zero params:");

		// Using lambda expression that wraps call to original method
		ToIntFunction<String> strToLengthLambda = s -> s.length();
		int strLen = strToLengthLambda.applyAsInt("wonderland");
		System.out.println("strToLength(\"wonderland\") (lamda) = " + strLen);

		// Using unbound method reference that refers to original method
		ToIntFunction<String> strToLength = String::length;
		strLen = strToLength.applyAsInt("wonderland");
		System.out.println("strToLength(\"wonderland\") (meth-ref) = " + strLen);

		System.out.println();

		// =================================================================

		// 2. Getter methods of any Java Bean class:

		System.out.println("2. Getter methods of any Java Bean class:");
		User user1 = new User("hungry.batman.91", 15);

		// Using lambda expression that wraps call to original method
		Function<User, String> getNameLambda = user -> user.getName();
		String userName = getNameLambda.apply(user1);
		System.out.println("getName(user) (lamda) = " + userName);

		// Using unbound method reference that refers to original method
		Function<User, String> getName = User::getName;
		userName = getName.apply(user1);
		System.out.println("getName(user) (meth-ref) = " + userName);

		System.out.println();

		// =================================================================

		// 3. Instance methods that accept one param:

		System.out.println("3. Instance methods that accept one param:");

		// Using lambda expression that wraps call to original method
		ToIntBiFunction<String, String> indexOfLambda = (sentence, word) -> sentence.indexOf(word);
		int wordIndex = indexOfLambda.applyAsInt("The Dark Knight", "Dark");
		System.out.println("indexOf(\"The Dark Knight\", \"Dark\") (lamda) = " + wordIndex);

		// Using unbound method reference that refers to original method
		ToIntBiFunction<String, String> indexOf = String::indexOf;
		wordIndex = indexOf.applyAsInt("The Dark Knight", "Dark");
		System.out.println("indexOf(\"The Dark Knight\", \"Dark\") (meth-ref) = " + wordIndex);

		System.out.println();

		// =================================================================

	}

}
