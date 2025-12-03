package com.streams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreams {

	public static void main(String[] args) {

		List<String> courses = Arrays.asList("Java", "Angular", "React", "CSS", "Java", "Spring", "XML", "Jupyter",
				"JavaScript", "Lua");
		Stream<String> courseStream = courses.stream();
		courseStream.forEach(course -> System.out.println(course));

		String[] fruits = { "apple", "kiwi", "orange" };
		Stream.of(fruits);
		// for variable number of arguments: Stream<T> Stream.of(T... values)
		Stream.of(10, 20, 30, 40); // returns Stream<Integer>

		// use Arrays.stream(primitive array)
		// - for getting stream of an array of primitives
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };
		Arrays.stream(primes); // returns IntStream - which is a specialized stream class for int primitives
		// Primitive (specialized) Streams support in-built aggregate methods like
		// sum(), average() etc.

		// For Integer array - Stream<Integer>
		Integer[] numbObjs = new Integer[] { 10, 20, 30 };
		Arrays.stream(numbObjs); // returns Stream<Integer>
		// Object (i.e. Wrapper class e.g. Integer) Streams DON'T HAVE in-built
		// aggregate methods
		// like sum(), average() etc. Instead, we need to manually use a reduce() to
		// compute these.

		// generating streams
		// <T>Stream.generate(Supplier<T>) this generates an infinite stream
		// try removing .limit(10) method call
		Stream.generate(Math::random).limit(10).forEach(System.out::println);

	}

}
