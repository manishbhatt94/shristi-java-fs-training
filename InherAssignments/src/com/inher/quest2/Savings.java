package com.inher.quest2;

public class Savings extends Account {

	public Savings() {
		super(0.0);
	}

	@Override
	public void withdraw(double amount) {
		// 0.10% fees on withdrawals
		double penalty = 0.10;
		double fees = (penalty * amount) / 100.0;
		System.out.println();
		System.out.println("Attempting to withdraw from your savings bank account...");
		if (this.balance <= (amount + fees)) {
			System.out.println(String.format(
					"Insufficient balance to withdraw ₹%.4f from your Savings account. Note withdrawals are charged at %.2f%% of withdrawal amount.",
					amount, penalty));
			return;
		}
		balance -= (amount + fees);
		System.out.println(String.format("Withdrew ₹%.4f from your Savings account.", amount));
		System.out.println(String.format("Withdrawal fee: ₹%.4f (at the rate of %.2f%%).", fees, penalty));
		System.out.println(String.format("Present account balance = ₹%.4f", balance));
	}

	@Override
	public void deposit(double amount) {
		// zero fees on deposits
		balance += amount;
		System.out.println();
		System.out.println("Attempting to deposit to your savings bank account...");
		System.out.println(String.format("Deposited ₹%.4f in your Savings account.", amount));
		System.out.println(String.format("Present account balance = ₹%.4f", balance));
	}
}
