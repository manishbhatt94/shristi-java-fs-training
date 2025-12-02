package com.streams.basics;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncObjDemo {

	public static void main(String[] args) {

		Consumer<String> strConsumer = str -> System.out.println(str.toUpperCase());
		strConsumer.accept("Kishore");

		Book book = new Book("Head First Java 3E", 945.0, 128, "Kathy Sierra");
		Consumer<Book> bookConsumer = (Book aBook) -> System.out.println(aBook);
		bookConsumer.accept(book);

		Predicate<Book> bookPredicate = bookObj -> {
			return bookObj.getTitle().equals("Spring");
		};
		System.out.println(bookPredicate.test(book));

		Supplier<Book> bookSupplier = () -> new Book("Spring", 1230.0, 172, "Martin Fowler");
		System.out.println(bookSupplier.get());

		Function<Book, String> bookFunction = (bookObj) -> bookObj.getTitle();
		System.out.println(bookFunction.apply(new Book("The C Programming Language", 275.0, 115, "Dennis Ritchie")));
	}

}
