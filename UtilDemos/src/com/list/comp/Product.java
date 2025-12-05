package com.list.comp;

import java.util.Objects;

public class Product implements Comparable<Product> {

	private String productName;
	private double price;
	private String brand;
	private int productId;

	public Product() {
		super();
	}

	public Product(String productName, double price, String brand, int productId) {
		super();
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		return productId == other.productId && Objects.equals(productName, other.productName);
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", brand=" + brand + ", productId="
				+ productId + "]";
	}

	@Override
	public int compareTo(Product o) {
		return o.getProductName().compareTo(this.getProductName());
	}

}
