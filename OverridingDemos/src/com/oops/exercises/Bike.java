package com.oops.exercises;

public class Bike extends Vehicle {
	int cc;
	String ignitionType;
	boolean isGearless;

	public Bike(String brand, double price, String model, int cc, String ignitionType, boolean isGearless) {
		super(brand, price, model);
		this.cc = cc;
		this.ignitionType = ignitionType;
		this.isGearless = isGearless;
	}

	@Override
	void getMileage() {
		if (isGearless) {
			System.out.println("Mileage is okay for bike");
		} else {
			System.out.println("Good mileage for bike");
		}
	}

	String[] showBrands(String type) {
		if (type.equals("sports")) {
			return new String[] { "Kawasaki" };
		} else if (type.equals("mountain")) {
			return new String[] { "Himalayan" };
		} else {
			return null;
		}
	}

	void bikeInfo() {
		System.out.println("Details of car");
		printDetails();
		System.out.println("Bike engine cc: " + cc);
		System.out.println("Ignition type: " + ignitionType);
		System.out.println("Gearless? " + isGearless);
	}
}
