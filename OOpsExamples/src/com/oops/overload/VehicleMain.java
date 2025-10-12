package com.oops.overload;

public class VehicleMain {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("City", "Honda", 9_72_839.0);
		vehicle1.getDetails();
		System.out.println();

		Vehicle vehicle2 = new Vehicle("City");
		vehicle2.getDetails();
		System.out.println();

		Vehicle vehicle3 = new Vehicle("City", "Honda");
		vehicle3.getDetails();
		System.out.println();

		Vehicle vehicle4 = new Vehicle();
		vehicle4.getDetails();
		System.out.println();
	}
}
