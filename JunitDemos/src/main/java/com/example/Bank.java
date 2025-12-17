package com.example;

public class Bank {

	double balance;

	public Bank(double balance) {
		super();
		this.balance = balance;
	}

	public double withdraw(double amount) {
		if (amount > 5000.0) {
			throw new ExceedsWithdrawalLimitException("Each withdrawal can be of at most ₹5000/- only.");
		}
		balance -= amount;
		return balance;
	}

}
