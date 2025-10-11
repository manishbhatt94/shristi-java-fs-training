package com.oops.inherit;

public class Manager extends Employee {

	double salary;

	void calcBonus(double amount) {
		System.out.println("Bonus = " + (salary + amount));
	}
}
