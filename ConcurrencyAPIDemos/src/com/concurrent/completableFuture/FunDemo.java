package com.concurrent.completableFuture;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunDemo {

	public static void main(String[] args) {

		// Demo for Supplier<T>
		Supplier<String> supplyString = () -> "Good evening!";
		System.out.println(supplyString.get());

		Supplier<Double> supplyRandom = () -> Math.random();
		System.out.println(supplyRandom.get());

		showMessage(supplyString, "Manish");
		showMessage(() -> "What's up?", "Rashmi");

		getMessage(str -> System.out.println(str.toUpperCase()), "Java Full Stack");

		// Demo for Consumer<T>
		Consumer<String> consumeString = str -> {
			System.out.println(str.toUpperCase());
		};
		consumeString.accept("Spoorthy");

		// Demo for Function<T, R>
		Function<String, Integer> func = str -> str.length();
		System.out.println(func.apply("Kamal"));
		int checksum = getMessageChecksum(msg -> msg.length() * 41, "The quick brown fox jumps over the lazy dog.");
		System.out.println("Checksum: " + checksum);

		// Demo for BiFunction<T, U, R> - takes two params of types T & U, and returns
		// value of type R.
		BiFunction<String, Integer, Boolean> isLongEnough = (str, minLen) -> str.length() >= minLen;
		System.out.println("isLongEnough \"Watermelon\" (min 5 chars)? -> " + isLongEnough.apply("Watermelon", 5));

	}

	private static void showMessage(Supplier<String> supplier, String name) {
		System.out.println(supplier.get() + " " + name);
	}

	private static void getMessage(Consumer<String> consumer, String message) {
		System.out.println("Started");
		consumer.accept(message);
	}

	private static Integer getMessageChecksum(Function<String, Integer> checksumCalculator, String message) {
		return checksumCalculator.apply(message);
	}
}
