package com.concurrent.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {

	public static void main(String[] args) {
		Bank bank = new Bank();
		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(new Runner(bank, "Raju", 10000.0));
		service.execute(new Runner(bank, "Mohan", 4500.0));
		service.execute(new Runner(bank, "Tarun", 13600.0));
		service.shutdown();
	}
}

class Runner implements Runnable {

	private Bank bank;
	private String name;
	private double amount;

	public Runner(Bank bank, String name, double amount) {
		super();
		this.bank = bank;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		System.out.printf("[%s] Inside run.\n", thread);
		System.out.printf("[%s] Calculating interest (name: %s, amount=%.2f).\n", thread, name, amount);
		double interest = bank.calcInterest(name, amount);
		System.out.printf("[%s] interest: %.2f.\n", thread, interest);
		String billType = "mobile";
		double billAmount = 2000.0;
		System.out.printf("[%s] Paying bill (type: %s, amount: %.2f).\n", thread, billType, billAmount);
		bank.payBills("mobile", 2000);
	}

}
