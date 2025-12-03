package com.streams.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalSecondDemo {

	public static void main(String[] args) {

		List<String> courses = Arrays.asList("Java", "Angular", "React", "CSS", "Java", "Spring", "XML", "Jupyter",
				"JavaScript", "Lua");

		Optional<String> opt = courses.stream().filter(str -> str.startsWith("D")).findFirst();
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}

		// Optional<T> object has .orElse(<alt-value>) method
		// which is for eagerly providing alternate value
		String result = courses.stream().filter(str -> str.startsWith("D")).findFirst().orElse("No courses available");
		System.out.println(result);
		System.out.println();
		// Putting method call getSubstituteCourse() inside .orElse(...) call
		// i.e. .orElse(getSubstituteCourse())
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst().orElse(getSubstituteCourse());
		System.out.println(result);
		System.out.println();

		// Optional<T> object has .orElseGet(Supplier<T> supplier) method
		// which is for lazily providing alternate value
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst()
				.orElseGet(() -> "Lazy message - No such course");
		System.out.println(result);
		System.out.println();
		// Putting a supplier with method call getSubstituteCourse() inside
		// .orElseGet(...) call
		// i.e. .orElseGet(() -> getSubstituteCourse())
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst().orElseGet(() -> getSubstituteCourse());
		System.out.println(result);
		System.out.println();

		// Optional<T> object has .or(Supplier<Optional<T>> supplier) method.
		// If a value is present, returns an Optional describing the value,
		// otherwise returns an Optional produced by the supplying function.
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst()
				.or(() -> Optional.of("Microservice - Coming Soon")).get();
		System.out.println(result);
		System.out.println();

		// Optional<T> object has .orElseThrow()
		// which throws a java.util.NoSuchElementException if the value
		// wrapped by the Optional is null
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst().orElseThrow();
		System.out.println(result);
		System.out.println();

		// Optional<T> object has .orElseThrow(Supplier<? extends Throwable>
		// exceptionSupplier)
		// which allows us to throw any exception we want
		result = courses.stream().filter(str -> str.startsWith("D")).findFirst()
				.orElseThrow(() -> new RuntimeException("Lazy message - No such course"));
		System.out.println(result);
		System.out.println();

	}

	private static String getSubstituteCourse() {
		System.out.println("Finding substitute course...");
		return "Undefined-Course";
	}

}
