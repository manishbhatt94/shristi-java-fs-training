package com.oops.override;

public class Manager extends Employee {

	@Override
	void calcBonus(double amount) {
		super.calcBonus(amount);
		System.out.println("Manager bonus " + (amount * 5));
	}
	
	void projectDetails() {
		System.out.println("Ecommerce Application");
	}
}
