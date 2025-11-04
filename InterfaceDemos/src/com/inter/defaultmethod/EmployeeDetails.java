package com.inter.defaultmethod;

public class EmployeeDetails implements IBonusCalculator, ILoanProcessor {

	@Override
	public void calculate(double amount) {
		System.out.println("Employee bonus calculation for base amount " + amount);
	}

	@Override
	public void processDetails() {
		// how to call a default method of an implemented interface
		// from the implementation class
		IBonusCalculator.super.processDetails();

		// and / or we call (also) call the default method from the other interface
		// ILoanProcessor.super.processDetails();
		System.out.println("processing ... for employee");
	}

	// own static method, not interface method
	static void showPolicy() {
		System.out.println("Policy specific to employees");
	}
}
