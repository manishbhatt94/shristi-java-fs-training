package com.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo1 {

	public static void main(String[] args) {

		CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Happy weekday!";
		});
		// thenAccept() method is non-blocking
		task1.thenAccept(str -> System.out.println(str.toUpperCase()));
		System.out.println("In main");

		try {
			// get() of Future is a blocking method
			System.out.println(task1.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In main - Completed.");
	}
}
