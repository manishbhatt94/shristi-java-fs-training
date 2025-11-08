package com.excep.userdefined;

public class HdATM {

	public static void main(String[] args) {
		HdBank bank = new HdBank(4000.0);
		try {
			bank.withdraw(10000);
		} catch (ExceedingLimitsException e) {
			System.out.println("Problem occured: " + e.getMessage());
		} catch (MinBalanceException e) {
			System.out.println("Ran into an issue: " + e.getMessage());
		}
	}
}
