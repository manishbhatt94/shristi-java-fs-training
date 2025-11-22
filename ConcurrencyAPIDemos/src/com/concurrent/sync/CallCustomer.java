package com.concurrent.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallCustomer {

	public static void main(String[] args) {

		Bank bank = new Bank();

		// implement Callable
		Callable<Double> call = () -> {
			String thread = Thread.currentThread().getName();
			System.out.printf("[%s] Inside run.\n", thread);
			String name = "Manish";
			double amount = 2000.0;
			System.out.printf("[%s] Calculating interest (name: %s, amount=%.2f).\n", thread, name, amount);
			double interest = bank.calcInterest("Priya", 2000.0);
			System.out.printf("[%s] interest: %.2f.\n", thread, interest);
			return interest;
		};

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Double> futureInterest = executorService.submit(call);
		try {
			System.out.println("Interest is (result from future): " + futureInterest.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println();

		Future<String> futureGreeting = executorService.submit(() -> {
			System.out.println("Inside greeting callable");
			return "Welcome to Async";
		});

		try {
			System.out.println(futureGreeting.cancel(true));
			System.out.println(futureGreeting.isCancelled());
			System.out.println(futureGreeting.isDone());
			System.out.println("Greeting is (result from future): " + futureGreeting.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

	}
}
