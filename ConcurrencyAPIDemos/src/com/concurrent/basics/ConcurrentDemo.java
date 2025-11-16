package com.concurrent.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentDemo {

	public static void main(String[] args) {
		// Create a thread pool using Executors
		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 1; i < 20; i++) {
			final int taskId = i;
			service.execute(() -> {
				System.out.printf("Hello [By Thread: %s] -- Task #%d.\n\n", Thread.currentThread().getName(), taskId);
			});
		}

		service.shutdown();
	}
}
