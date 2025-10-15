package com.oops.exercises;

public class Car extends Vehicle {

	String color;
	String type;

	public Car(String brand, double price, String model, String color, String type) {
		super(brand, price, model);
		this.color = color;
		this.type = type;
	}

	@Override
	void getMileage() {
		System.out.println("Car mileage is good");
	}

	String[] showAccessories() {
		return new String[] { "Car Cover", "Rear A/C", "Music System" };
	}

	void carInfo() {
		System.out.println("Details of car");
		printDetails();
		System.out.println("Color: " + color);
		System.out.println("Type: " + type);
	}
}
