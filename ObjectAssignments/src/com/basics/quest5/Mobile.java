package com.basics.quest5;

public class Mobile {

	String model;
	String brand;
	String color;
	double price;

	public Mobile(String model, String brand, String color, double price) {
		super();
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	public void getDetails() {
		System.out.println("\nMobile Specs:");
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Color: " + color);
		System.out.println(String.format("Price: ₹%.2f", price));
	}
}
