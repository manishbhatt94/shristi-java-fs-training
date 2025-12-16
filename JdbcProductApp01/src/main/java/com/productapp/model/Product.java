package com.productapp.model;

public class Product {

	private int productId;
	private String productName;
	private String brand;
	private String category;
	private double price;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String brand, String category, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	public Product(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", category="
				+ category + ", price=" + price + "]";
	}

}
