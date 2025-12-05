package com.io.exercise1;

import java.util.List;

class BookMain {

	public static void main(String[] args) {

		// GDPH
		// https://www.classroomclipboard.com/892826
		// Return code: HF3B-S8B9
		IBookConverter converter = new BookConverterImpl();

		// call the method to get the csv file & convert to list
		List<Book> books = converter.convertToList("books.csv");
		System.out.println(books);

		// serialize the books
		String serializedFile = converter.serializeBooks(books);

		// deserialize books - read the serialized file & print the
		converter.deserializeBooks(serializedFile);
	}
}
