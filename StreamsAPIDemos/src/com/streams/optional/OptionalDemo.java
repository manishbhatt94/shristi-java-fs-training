package com.streams.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		double volume = 12.54;
		Optional<Double> optVolume = Optional.of(volume);
		System.out.println(optVolume.get());
		System.out.println();

		String name = "Manish";
		Optional<String> optName = Optional.of(name);
		System.out.println(optName);
		System.out.println(optName.get());
		System.out.println();
		// ================================================

		name = "Manish";
		optName = Optional.empty();
		System.out.println(optName);
		// throws java.util.NoSuchElementException
		// when calling .get() on an empty Optional object
		// System.out.println(optName.get());
		System.out.println();
		// ================================================

		name = null;
		// Optional.of(<null value>)
		// Optional.of method throws NullPointerException (NPE)
		// when we pass it a null value
		// optName = Optional.of(name);
		// System.out.println(optName);
		// System.out.println(optName.get());
		// System.out.println();
		// ================================================

		name = "Manish";
		// use Optional.ofNullable if the value passed to it
		// might be null
		// Optional.ofNullable(.) call will NOT throw NPE, when we pass
		// a null value to it
		optName = Optional.ofNullable(name);
		System.out.println(optName);
		System.out.println(optName.get());
		System.out.println();
		// ================================================

		name = null;
		// use Optional.ofNullable if the value passed to it
		// might be null
		// Optional.ofNullable(.) call will NOT throw NPE, when we pass
		// a null value to it
		optName = Optional.ofNullable(name);
		System.out.println(optName);
		// optName.get() call throws java.util.NoSuchElementException
		// when calling .get() on an Optional object created
		// using Optional.ofNullable(<null value>)
		// System.out.println(optName.get());
		System.out.println();
		// ================================================

		System.out.println("Trying various methods of Optional objects:\n");

		optName.ifPresent(System.out::println);
		optName.ifPresentOrElse(System.out::println, () -> System.out.println("Default Value"));
		System.out.println();
		// ================================================

		if (optName.isPresent()) {
			System.out.println("Value present - " + optName.get());
		}
		if (optName.isEmpty()) {
			System.out.println("Value absent - Default: John-Doe");
		}

	}

}
