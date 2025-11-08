package com.excep.userdefined;

public class HdBank {

	double balance;

	public HdBank(double balance) {
		super();
		this.balance = balance;
	}

	void withdraw(double amount) throws ExceedingLimitsException, MinBalanceException {
		System.out.println("In HD Bank withdraw method");
		try {
			if (amount > 5000) {
				throw new ExceedingLimitsException("Amount should be less than 5000");
			}
			if (balance - amount < 2000) {
				throw new MinBalanceException("Minimum balance not maintained");
			}

			balance -= amount;
			System.out.println("Amount withdrawn successfully");
		} catch (Exception e) {
			System.out.println("Wrong input");
			throw e;
		} finally {
			System.out.println("Close the DB");
		}
		System.out.println("Work done");
	}
}
