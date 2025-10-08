package com.oops.basics;

public class Book {

	String title;
	String author;
	double price;

	Book(String title, String author, double prince) {
		super();
		this.title = title;
		this.author = author;
		this.price = prince;
	}
	
	void printInfo() {
		System.out.println(title + " " + author + " " + price);
	}
}
