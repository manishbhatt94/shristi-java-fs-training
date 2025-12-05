package com.io.exercise1;

import java.util.List;

public interface IBookConverter {

	List<Book> convertToList(String csvFile);

	String serializeBooks(List<Book> books); // return the serialized file name

	void deserializeBooks(String serializedFile);
}
