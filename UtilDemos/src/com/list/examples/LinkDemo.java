package com.list.examples;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkDemo {

	public static void main(String[] args) {

		LinkedList<String> myList = new LinkedList<>();
		myList.add("apple");
		myList.add("100");
		myList.addLast("kiwi");
		myList.offerFirst("blueberry");
		myList.add("orange");
		myList.add(1, "banana");
		System.out.println(myList);
		System.out.println();

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str.toLowerCase());
		}
		System.out.println();

		// use methods of Deque
		System.out.println(myList.element());
		System.out.println(myList);
		System.out.println(myList.peek());
		System.out.println(myList);
	}
}
