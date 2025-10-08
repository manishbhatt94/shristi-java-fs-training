package com.oops.basics;

public class Product {
	int id;
	String name;
	String brand;
	double price;

	public Product(int id, String name, String brand, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	void printInfo() {
		System.out.println("\nProduct ID: " + id);
		System.out.println("Product name: " + name);
		System.out.println("Product brand: " + brand);
		System.out.println("Product price: " + price);
	}

	double totalCost(int quantity) {
		return price * quantity;
	}

	String[] showModels(String brand) {
		if (brand.equalsIgnoreCase("samsung")) {
			return new String[] { "s24", "s24-fe" };
		}
		if (brand.equalsIgnoreCase("apple")) {
			return new String[] { "iphone-17", "iphone-se" };
		}
		return new String[] {};
	}
}
