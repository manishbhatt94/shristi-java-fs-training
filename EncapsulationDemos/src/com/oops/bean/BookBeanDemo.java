package com.oops.bean;

public class BookBeanDemo {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.setTitle("Pattern Recognition");
		book1.setAuthor("William Gibson");
		book1.setPrice(199.0);
		book1.setAvailable(false);
		System.out.println(book1.getTitle());
		System.out.println(book1.getAuthor());
		System.out.println(book1.getPrice());
		System.out.println(book1.isAvailable());
		System.out.println(book1);
		System.out.println();

		Book book2 = new Book();
		book2.setTitle("Along Came a Spider");
		book2.setAuthor("James Patterson");
		book2.setPrice(250.0);
		book2.setAvailable(true);
		System.out.println(book2.getTitle());
		System.out.println(book2.getAuthor());
		System.out.println(book2.getPrice());
		System.out.println(book2.isAvailable());
		System.out.println(book2);
	}
}
