package com.streams.basics;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class PrimitiveStreams {

	public static void main(String[] args) {

		int[] nums = { 10, 45, 11, 66, 84, 65, 36, 20, 81 };

		// primitive array to stream - Arrays.stream(primitive array)

		int total = Arrays.stream(nums).sum();
		System.out.println("Total = " + total);

		// average() method (on IntStream object) returns a specialized Optional object
		// of type OptionalDouble
		OptionalDouble optDouble = Arrays.stream(nums).average();
		// Optional<Double> or Optional<T> has get() method, i.e. public T get()
		// But, OptionalDouble has method - public double getAsDouble()
		// Similarly, OptionalInt has method - public int getAsInt()
		System.out.println("Average = " + optDouble.getAsDouble());
		// OptionalDouble optDouble = Arrays.stream(new int[] {}).average();
		optDouble.ifPresentOrElse((avg) -> System.out.println("Average = " + avg),
				() -> System.out.println("Can't find average of empty array of intgers"));

		// max() method (on IntStream object) returns a specialized Optional object
		// of type OptionalInt
		int max = Arrays.stream(nums).filter(num -> num % 2 == 0).max().getAsInt();
		System.out.println("Max of even numbers in the nums[] array = " + max);

		// IntStream.range(int startInclusive, int endExclusive)
		IntStream.range(10, 15).filter(num -> num % 2 != 0).forEach(System.out::println);
		System.out.println();

		// rangeClosed(int startInclusive, int endInclusive)
		IntStream.rangeClosed(10, 15).filter(num -> num % 2 != 0).forEach(System.out::println);
		System.out.println();

	}

}
