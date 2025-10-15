package com.oops.exercises;

public class Vehicle {

	String brand;
	double price;
	String model;

	public Vehicle(String brand, double price, String model) {
		super();
		this.brand = brand;
		this.price = price;
		this.model = model;
	}

	void printDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Price: " + price);
	}

	void getMileage() {
		System.out.println("Vehicle mileage");
	}
}
