package com.streams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {

		List<String> courses = Arrays.asList("Java", "Angular", "React", "CSS", "Java", "Spring", "XML", "Jupyter",
				"JavaScript", "Lua");

		courses.stream().filter(str -> str.length() > 3).filter(str -> str.startsWith("J"))
				.forEach(str -> System.out.println(str.toUpperCase()));
		System.out.println();

		// Note the method reference String::length passed to mapToInt
		// need to study about this type of method reference since length() is not
		// a static method of String class
		int sumOfWordLengths = courses.stream().mapToInt(String::length).sum();
		System.out.println("sumOfWordLengths = " + sumOfWordLengths);
		System.out.println();

		// sorted, limit, skip, distinct
		courses.stream().filter(str -> str.length() > 3).sorted().distinct().skip(2).limit(3)
				.forEach(str -> System.out.println(str));
		System.out.println();

		// map, toList
		List<String> ncourses = courses.stream().filter(str -> str.length() > 3).map(str -> str.concat(" Course"))
				.toList();
		System.out.println(ncourses);
		System.out.println();

		// map, collect (Collectors.toList())
		List<Integer> strLengths = courses.stream().filter(str -> str.length() > 3).map(str -> str.length())
				.collect(Collectors.toList());
		System.out.println(strLengths);
		System.out.println();

		// flatMap
		String[][] stateCities = { { "Allahabad", "Lucknow", "Banaras" }, { "Bengaluru", "Hassan", "Davangere" } };
		// String[][] to String[]
		Stream<String[]> statesStream = Arrays.stream(stateCities);
		// String[] to String
		Stream<String> citiesStream = statesStream.flatMap(states -> Arrays.stream(states));
		citiesStream.forEach(System.out::println);
		System.out.println();

		List<Integer> nums = List.of(10, 45, 11, 66, 84, 65, 36, 20, 81);
		// reduce WITHOUT initial value - returns Optional (coz stream maybe empty)
		Optional<Integer> optNumSum = nums.stream().reduce((a, b) -> a + b);
		System.out.println(optNumSum.get());
		System.out.println();

		// 'nums' list currently has only odd numbers
		// and we're filter the stream to only contain even numbers
		nums = List.of(65, 87, 53);

		// stream after filtering, is empty
		// * reduce() without initial value - in this case the Optional returned is
		// empty
		optNumSum = nums.stream().filter(x -> x % 2 == 0).reduce((a, b) -> a + b);
		int sum = optNumSum.orElse(123456789);
		System.out.println(sum);
		System.out.println();

		// 'nums' list currently has only odd numbers
		// and we're filter the stream to only contain even numbers

		// stream after filtering, is empty
		// * reduce() with initial value - doesn't return Optional
		sum = nums.stream().filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		System.out.println();

	}

}
