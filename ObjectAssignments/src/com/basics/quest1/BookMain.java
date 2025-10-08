package com.basics.quest1;

public class BookMain {

	public static void main(String[] args) {
		Book b1 = new Book("Conversational Kannada", "N D Krishnamurthy", 413.0, "Language Self Learn");
		b1.getDetails();
		b1.checkBookType();

		Book b2 = new Book("Patterns of Distributed Systems", "Unmesh Joshi", 567.0, "Engineering Computer Science");
		b2.getDetails();
		b2.checkBookType();
	}
}
