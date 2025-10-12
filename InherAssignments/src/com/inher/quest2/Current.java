package com.inher.quest2;

public class Current extends Account {

	public Current() {
		super(0.0);
	}

	@Override
	public void withdraw(double amount) {
		// 0.75% fees on withdrawals
		double penalty = 0.75;
		double fees = (penalty * amount) / 100.0;
		System.out.println();
		System.out.println("Attempting to withdraw from your current bank account...");
		if (this.balance <= (amount + fees)) {
			System.out.println(String.format(
					"Insufficient balance to withdraw ₹%.4f from your Current account. Note withdrawals are charged at %.2f%% of withdrawal amount.",
					amount, penalty));
			return;
		}
		balance -= (amount + fees);
		System.out.println(String.format("Withdrew ₹%.4f from your Current account.", amount));
		System.out.println(String.format("Withdrawal fee: ₹%.4f (at the rate of %.2f%%).", fees, penalty));
		System.out.println(String.format("Present account balance = ₹%.4f", balance));
	}

	@Override
	public void deposit(double amount) {
		// 0.40% fees on deposits
		double penalty = 0.75;
		double fees = (penalty * amount) / 100.0;
		balance += (amount - fees);
		System.out.println();
		System.out.println("Attempting to deposit to your current bank account...");
		System.out.println(String.format("Deposited ₹%.4f in your Current account.", amount));
		System.out.println(String.format("Deposit fee: ₹%.4f (at the rate of %.2f%%).", fees, penalty));
		System.out.println(String.format("Present account balance = ₹%.4f", balance));
	}
}
