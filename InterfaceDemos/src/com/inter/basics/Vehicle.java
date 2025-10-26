package com.inter.basics;

public class Vehicle implements IInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Policy for engine and parts");
	}
	
	void printMileage() {
		System.out.println("Good mileage");
	}
}
