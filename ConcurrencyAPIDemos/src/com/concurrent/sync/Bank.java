package com.concurrent.sync;

public class Bank {

	public double calcInterest(String name, double amount) {
		String thread = Thread.currentThread().getName();
		System.out.printf("[%s] Interest calculation for %s.\n", thread, name);
		double interest = (amount * 3 * 5) / 100;
		System.out.printf("[%s] Interest: %.2f.\n", thread, interest);
		return interest;
	}

	public void payBills(String type, double amount) {
		String thread = Thread.currentThread().getName();
		System.out.printf("[%s] Bill payment for %s.\n", thread, type);
		System.out.printf("[%s] Paid %.2f.\n", thread, amount);
	}
}
