package com.oops.override;

public class Developer extends Employee {

	@Override
	void calcBonus(double amount) {
		super.calcBonus(amount);
		System.out.println("Developer bonus " + (amount * 3));
	}
}
