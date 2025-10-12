package com.oops.suuuperrr;

public class SupMain {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("A123", 1000);
		vehicle.getDetails();

		Car car = new Car("X12", 20000.0, "Silver");
		car.getDetails();
	}
}
