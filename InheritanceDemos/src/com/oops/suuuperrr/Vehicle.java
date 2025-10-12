package com.oops.suuuperrr;

public class Vehicle {

	String model;

	public Vehicle(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	double price;

	public void getDetails() {
		System.out.println("Model: " + model);
		System.out.println("Price: " + price);
	}
}
