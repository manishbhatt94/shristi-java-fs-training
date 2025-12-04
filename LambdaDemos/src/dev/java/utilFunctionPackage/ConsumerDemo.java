package dev.java.utilFunctionPackage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;

public class ConsumerDemo {

	public static void main(String[] args) {

		// from previous example on Supplier
		Random random = new Random();
		IntSupplier randSupplier = () -> random.nextInt(10);

		// consuming a string - to print it out
		Consumer<String> printer = s -> System.out.println(s);
		for (int i = 0; i < 5; i++) {
			int nextRandom = randSupplier.getAsInt();
			printer.accept("next random = " + nextRandom);
		}
		System.out.println();

		// Using Specialized Consumers
		// JDK provides three (3) specialized Consumer functional interfaces
		// for dealing with primitive values:
		// IntConsumer, LongConsumer, and DoubleConsumer.
		// Which all have the same functional method: void accept().
		// Note: here with consumers, return type is void for all, so there was no
		// need for separate name for the functional method for each specialized
		// consumer.
		DoubleConsumer sqRootPrinter = num -> System.out.printf("Square root of %.2f = %.2f.%n", num, Math.sqrt(num));
		sqRootPrinter.accept(20.25);
		System.out.println();

		// Consuming Two Elements with a BiConsumer<T, U>
		// Represents an operation that accepts two input arguments and returns no
		// result. This is the two-arity specialization of Consumer.
		BiConsumer<Random, Integer> randNumPrinter = (randObj, number) -> {
			for (int i = 0; i < number; i++) {
				System.out.println("next random = " + randObj.nextInt());
			}
		};
		randNumPrinter.accept(new Random(314L), 3);
		System.out.println();

		// Specialized version(s) of BiConsumer for operating on an object value & a
		// primitive value. First parameter of accept will be an object type, and the
		// second parameter will be a primitive type (either int, long, or double).
		// Below three (3) specialized BiConsumer functional interfaces are available:
		// interface ObjIntConsumer<T> { void accept(T t, int value); }
		// interface ObjLongConsumer<T> { void accept(T t, long value); }
		// interface ObjDoubleConsumer<T> { void accept(T t, double value); }
		ObjIntConsumer<List<Integer>> listIndexValuePrinter = (nums, index) -> {
			System.out.printf("Value at index %d in the list = %d.%n", index, nums.get(index));
		};
		listIndexValuePrinter.accept(List.of(11, 13, 17, 19, 23), 3);
		System.out.println();

		// Passing a Consumer to an Iterable
		// Iterable interface has a default method called `forEach` since Java 1.8
		// @formatter:off
		// interface Iterable<T> {
		// 		default void forEach(Consumer<? super T> action) { ... }
		// }
		// @formatter:on
		List<String> names = Arrays.asList("Malcolm", "Martin", "Shakur", "Jackson", "Carter");
		names.forEach(printer);
		System.out.println();
		names.forEach(str -> {
			System.out.printf("'%s' -> Length: %d chars.%n", str, str.length());
		});

	}

}
