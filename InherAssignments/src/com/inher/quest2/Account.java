package com.inher.quest2;

import java.util.List;

public class Account {

	double balance;

	static final List<String> validAccountTypes = List.of("savings", "current");

	public Account() {
		super();
		this.balance = 0.0;
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		// no-op method
	}

	public void deposit(double amount) {
		// no-op method
	}
}
