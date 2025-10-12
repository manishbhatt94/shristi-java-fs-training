package com.oops.overload;

public class Vehicle {

	String model;
	String brand;
	double price;

	public Vehicle() {
		super();
		System.out.println("In default (zero param) constructor");
	}

	public Vehicle(String model) {
		this();
		System.out.println("In one param constructor");
		this.model = model;
	}

	public Vehicle(String model, String brand) {
		this(model);
		System.out.println("In two param constructor");
		this.brand = brand;
	}

	public Vehicle(String model, String brand, double price) {
		this(model, brand);
		System.out.println("In three param constructor");
		this.price = price;
	}

	public void getDetails() {
		System.out.println("Model: " + model);
		System.out.println("Brand: " + brand);
		System.out.println("Price: " + price);
	}
}
