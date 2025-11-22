package com.concurrent.completableFuture;

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

		// Demo for Consumer<T>
		Consumer<String> consumeString = str -> {
			System.out.println(str.toUpperCase());
		};
		consumeString.accept("Spoorthy");

		// Demo for Funtion<T, R>
		Function<String, Integer> func = str -> str.length();
		System.out.println(func.apply("Kamal"));
		int checksum = getMessageChecksum(msg -> msg.length() * 41, "The quick brown fox jumps over the lazy dog.");
		System.out.println("Checksum: " + checksum);
	}

	private static void showMessage(Supplier<String> supplier, String name) {
		System.out.println(supplier.get() + " " + name);
	}

//	private static void

	private static Integer getMessageChecksum(Function<String, Integer> checksumCalculator, String message) {
		return checksumCalculator.apply(message);
	}
}
