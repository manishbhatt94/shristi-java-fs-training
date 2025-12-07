package dev.java.combineLamdas;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import dev.java.lambdasAsMethodReferences.User;

// Resource link: https://dev.java/learn/lambdas/combining-chaining-composing/

public class CombiningLambdasDemo {

	public static void main(String[] args) {
		chainingPredicates();
		predicateFactoryMethods();
		chainingConsumers();
		chainingFunctions();
		composingFunctions();
	}

	private static void chainingPredicates() {
		// Chaining Predicates demo:

		/**
		 * @formatter:off
		 * You have three tests on a given string:
		 * 1. non-null;
		 * 2. non-empty;
		 * 3. shorter than 3 characters.
		 * @formatter:on
		 */

		Predicate<String> p1 = s -> (s != null) && !s.isEmpty() && s.length() < 3;
		testPredicateChaining(p1);

		Predicate<String> nonNull = s -> s != null;
		Predicate<String> nonEmpty = s -> !s.isEmpty();
		Predicate<String> shorterThan3 = s -> s.length() < 3;
		Predicate<String> p2 = nonNull.and(nonEmpty).and(shorterThan3);
		testPredicateChaining(p2);

		Predicate<String> isNull = Objects::isNull;
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNullOrEmpty = isNull.or(isEmpty);
		Predicate<String> isNotNullNorEmpty = isNullOrEmpty.negate();
		Predicate<String> p3 = isNotNullNorEmpty.and(shorterThan3);
		testPredicateChaining(p3);
	}

	private static void testPredicateChaining(Predicate<String> predicate) {
		System.out.println(".test(null) -> " + predicate.test(null));
		System.out.println(".test(\"\") -> " + predicate.test(""));
		System.out.println(".test(\"a\") -> " + predicate.test("a"));
		System.out.println(".test(\"ab\") -> " + predicate.test("ab"));
		System.out.println(".test(\"abc\") -> " + predicate.test("abc"));
		System.out.println();
	}

	private static void predicateFactoryMethods() {
		// Creating Predicates with Factory Methods

		// static <T> Predicate<T> isEqual(Object targetRef) {}
		Predicate<String> isEqualToDuke = Predicate.isEqual("Duke");
		System.out.println(".test(\"abc\") -> " + isEqualToDuke.test("abc"));
		System.out.println(".test(\"duke\") -> " + isEqualToDuke.test("duke"));
		System.out.println(".test(\"Duke\") -> " + isEqualToDuke.test("Duke"));
		System.out.println();

		Predicate<Collection<String>> isCollectionEmpty = Collection::isEmpty;
		Predicate<Collection<String>> isCollectionNotEmpty = Predicate.not(isCollectionEmpty);

		List<String> list1 = List.of("Tom", "Jerry");
		List<String> list2 = List.of();

		System.out.println("isCollectionEmpty.test(list1) = " + isCollectionEmpty.test(list1));
		System.out.println("isCollectionNotEmpty.test(list1) = " + isCollectionNotEmpty.test(list1));
		System.out.println("isCollectionEmpty.test(list2) = " + isCollectionEmpty.test(list2));
		System.out.println("isCollectionNotEmpty.test(list2) = " + isCollectionNotEmpty.test(list2));

		System.out.println();
	}

	private static void chainingConsumers() {
		Consumer<String> prepareBreakfast = s -> System.out.println(s + ": Prepare breakfast.");
		Consumer<String> goShopping = s -> System.out.println(s + ": Go for shopping.");
		Consumer<String> watchMovie = s -> System.out.println(s + ": Watch a movie.");

		// using .addThen(Consumer<T> after) default method in Consumer<T> functional
		// interface to chain consumers
		Consumer<String> dayScheduleDialogues = prepareBreakfast.andThen(goShopping).andThen(watchMovie);

		dayScheduleDialogues.accept("Manish");

		System.out.println();
	}

	private static void chainingFunctions() {
		// Function<T, R> has a .andThen() default method for chaining
		// @formatter:off
		// default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
		//		return (T t) -> after.apply(apply(t));
		// }
		// @formatter:on
		// T -> R -> V
		// List<User> -> User -> String

		// 'this' function (applied first) -- Function<T, R>
		// T -> List<User>
		// R -> User
		Function<List<User>, User> getFirstUser = users -> users.get(0);

		// 'after' function (applied later) -- Function<R, V>
		// R -> User
		// V -> String
		Function<User, String> getUserLogin = user -> {
			return String.format("%s.%d", user.getName().replace(' ', '.'), user.getId());
		};

		// Chained Function:
		// getFirstUser.andThen(getUserLogin)
		// which means:
		// first = getFirstUser(usersList)
		// then..
		// output = getUserLogin(first)
		Function<List<User>, String> getFirstUserLogin = getFirstUser.andThen(getUserLogin);

		List<User> users = List.of(new User("Mike Tyson", 32), new User("Bruce Lee", 23));
		String result = getFirstUserLogin.apply(users);

		System.out.println("Function method `.addThen(after)` demo -> " + result);
		System.out.println();
	}

	private static void composingFunctions() {
		// Function<T, R> has a .compose() default method for chaining
		// @formatter:off
		// default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
		// 		return (V v) -> apply(before.apply(v));
		// }
		// @formatter:on
		// V -> T -> R
		// List<User> -> User -> String

		// 'before' function (applied first) -- Function<V, T>
		// V -> List<User>
		// T -> User
		Function<List<User>, User> getFirstUser = users -> users.get(0);

		// 'this' function (applied later) -- Function<T, R>
		// T -> User
		// R -> String
		Function<User, String> getUserLogin = user -> {
			return String.format("%s.%d", user.getName().replace(' ', '.'), user.getId());
		};

		// Composed Function:
		// getUserLogin( getFirstUser( usersList ) )
		Function<List<User>, String> getFirstUserLogin = getUserLogin.compose(getFirstUser);

		List<User> users = List.of(new User("Bruce Lee", 23), new User("Mike Tyson", 32));
		String result = getFirstUserLogin.apply(users);

		System.out.println("Function method `.compose(before)` demo -> " + result);
		System.out.println();
	}

}
