package com.streams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {

		List<String> courses = Arrays.asList("Java", "Angular", "React", "CSS", "Java", "Spring", "XML", "Jupyter",
				"JavaScript", "Lua");

		courses.stream().filter(str -> str.length() > 3).filter(str -> str.startsWith("J"))
				.forEach(str -> System.out.println(str.toUpperCase()));
		System.out.println();

		// sorted, limit, skip, distinct
		courses.stream().filter(str -> str.length() > 3).sorted().distinct().skip(2).limit(3)
				.forEach(str -> System.out.println(str));

		// map, toList
		List<String> ncourses = courses.stream().filter(str -> str.length() > 3).map(str -> str.concat(" Course"))
				.toList();
		System.out.println(ncourses);

		// map, collect (Collectors.toList())
		List<Integer> strLengths = courses.stream().filter(str -> str.length() > 3).map(str -> str.length())
				.collect(Collectors.toList());
		System.out.println(strLengths);

		// flatMap
		String[][] stateCities = { { "Allahabad", "Lucknow", "Banaras" }, { "Bengaluru", "Hassan", "Davangere" } };
		// String[][] to String[]
		Stream<String[]> statesStream = Arrays.stream(stateCities);
		// String[] to String
		Stream<String> citiesStream = statesStream.flatMap(states -> Arrays.stream(states));
		citiesStream.forEach(System.out::println);

	}

}
