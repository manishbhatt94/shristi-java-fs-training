package com.excep.throwsdemo;

public class Bank {

	void withdraw(int amount) {
		System.out.println("In Bank");
		try {
			int balance = 5000 / amount;
			System.out.println("Balance: " + balance);
		} catch (Exception e) {
			System.out.println("Technical error");
			throw e;
		} finally {
			System.out.println("Closing DB");
		}
		System.out.println("Work done");
	}
}
