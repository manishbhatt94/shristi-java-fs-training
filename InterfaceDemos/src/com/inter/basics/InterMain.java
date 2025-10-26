package com.inter.basics;

public class InterMain {

	public static void main(String[] args) {
		IInsurance insurance;

		insurance = new Vehicle();
		insurance.getPolicyDetails();

		Vehicle vehicle = (Vehicle) insurance;
		vehicle.printMileage();

		System.out.println();

		insurance = new Mobile();
		insurance.getPolicyDetails();

		Mobile mobile = (Mobile) insurance;
		mobile.showApps();

		System.out.println();

		// Warning - The static field IInsurance.POLICYNAME should be accessed in a
		// static way
		// System.out.println(mobile.POLICYNAME);
		System.out.println("Insurance Provider = " + IInsurance.POLICYNAME);
	}
}
