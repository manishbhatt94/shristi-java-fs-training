package com.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

public class Demo2 {

	public static void main(String[] args) {

		CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return "Happy weekday!";
		});
		task1.thenApply(str -> {
			System.out.println("Message: " + str);
			System.out.println("Concat");
			return str.concat(" Enjoy coding!");
		}).thenApply(str -> {
			System.out.println("Message: " + str);
			System.out.println("Format");
			return str.toUpperCase();
		}).thenAccept(str -> System.out.println(str));
	}
}
