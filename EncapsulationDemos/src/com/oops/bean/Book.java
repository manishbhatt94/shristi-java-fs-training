package com.oops.bean;

public class Book {

	private String title;
	private String author;
	private double price;
	private boolean available;

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", available=" + available + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
