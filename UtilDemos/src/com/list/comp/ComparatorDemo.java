package com.list.comp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {

		List<Book> books = Arrays.asList(new Book("Java", 900.8, 22, "Kathy"),
				new Book("Converation", 320.1, 12, "Kevin"), new Book("Habits", 670.5, 56, "Steve"),
				new Book("Yogi", 546.3, 82, "Benny"), new Book("Heal", 340.2, 10, "Joy"),
				new Book("Spring", 1900.8, 95, "Rod"));

		System.out.println("Sort by title");
		Comparator<Book> compTitle = new TitleSort();
		Collections.sort(books, compTitle);
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

		System.out.println("Sort by author");
		Collections.sort(books, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

		System.out.println("Sort by price");
		// Note: book.price field is a primitive - i.e. double.
		// Primitives don't have .compareTo instance method.
		// So we can use WrapperClass.compare(primitive p1, primitive p2) method.
		// class Double { @formatter:off
		// 		public static int compare(double d1, double d2) { ... }
		// } @formatter:on
		Comparator<Book> compPrice = (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice());
		Collections.sort(books, compPrice);
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

		System.out.println("Sort by ID (Reverse)");
		// Note: book.bookId field is an object field - i.e. Integer type (wrapper
		// class).
		// Whose objects do have the .compareTo instance method.
		// So we will be using that.

		// First, create a Comparator that sorts by bookId in ascending order.
		Comparator<Book> compId = (b1, b2) -> b1.getBookId().compareTo(b2.getBookId());
		// Then, call the .reversed() method on the above Comparator object,
		// to get as return, another Comparator object, that sorts in the reverse order.
		Comparator<Book> reversedCompId = compId.reversed();
		Collections.sort(books, reversedCompId);
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

	}

}
