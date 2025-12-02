package com.streams.basics;

public class Book {

	private String title;
	private double price;
	private int bookId;
	private String author;

	public Book() {
		super();
	}

	public Book(String title, double price, int bookId, String author) {
		super();
		this.title = title;
		this.price = price;
		this.bookId = bookId;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", bookId=" + bookId + ", author=" + author + "]";
	}

}
