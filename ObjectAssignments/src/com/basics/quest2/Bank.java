package com.basics.quest2;

public class Bank {
	double balance;
	
	public Bank(double balance) {
		this.balance = balance;
	}
	
	void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid withdraw amount: Select a positive number!");
			return;
		}
		if (this.balance <= amount) {
			System.out.println(String.format("Insufficient balance for withdrawing ₹%.2f", amount));
		} else {
			this.balance -= amount;
			System.out.println(String.format("₹%.2f have been debited from your bank account", amount));
		}
	}
	
	void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount: Select a positive number!");
			return;
		}
		this.balance += amount;
		System.out.println(String.format("₹%.2f have been credited to your bank account", amount));
	}
	
	double getBalance() {
		return this.balance;
	}
}
