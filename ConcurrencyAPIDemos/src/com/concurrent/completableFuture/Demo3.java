package com.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo3 {

	public static void main(String[] args) {

		CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Complete Task #1.";
		});
		CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return "Complete Task #2.";
		});

		// allOf
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2);
		// execute the tasks
		// thenRun() -> both the tasks are completed
		allTasks.thenRun(() -> {
			System.out.println("allTasks - thenRun()");
			System.out.println(Thread.currentThread().getName());
			try {
				System.out.println("Task #1 Result = " + task1.get());
				System.out.println("Task #2 Result = " + task2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		// anyOf
		CompletableFuture<Object> anyTasks = CompletableFuture.anyOf(task1, task2);
		anyTasks.thenAccept(str -> {
			System.out.println("anyTasks - thenAccept()");
			System.out.println("Value = " + str);
		});
	}
}
