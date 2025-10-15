package com.oops.exercises;

public class Showroom {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Car("Honda", 10_000.0, "City", "Silver", "Sedan");
		vehicle1.printDetails();
		vehicle1.getMileage();

		Car car = (Car) vehicle1;
		car.carInfo();
		String[] accessories = car.showAccessories();
		if (accessories != null) {
			for (String accessory : accessories) {
				System.out.println(accessory);
			}
		}

		Vehicle vehicle2 = new Bike("Kawasaki", 8000.0, "Ninja", 600, "Self Start", false);
		vehicle2.printDetails();
		vehicle2.getMileage();

		Bike bike = (Bike) vehicle2;
		bike.bikeInfo();

		String[] bikeBrands = bike.showBrands("mountain");
		if (bikeBrands != null) {
			for (String brand : bikeBrands) {
				System.out.println(brand);
			}
		}
	}
}
