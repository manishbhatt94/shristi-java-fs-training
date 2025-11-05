package com.excep.throwsdemo;

public class Bank {

	void withdraw(int amount) throws Exception {
		System.out.println("In Bank");
		try {
			if (amount <= 0) {
				throw new Exception();
			}
			System.out.println("Balance: " + amount);
		} catch (Exception e) {
			System.out.println("Technical error");
			throw e;
		} finally {
			System.out.println("Closing DB");
		}
		System.out.println("Work done");
	}
}
