package com.list.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {

		List<String> myList = new ArrayList<>();
		System.out.println(myList.size());
		myList.add("apple");
		myList.add("100");
		myList.add("orange");
		System.out.println(myList.size());
		myList.add("kiwi");

		System.out.println(myList);

		for (Object o : myList) {
			String str = (String) o;
			System.out.println(str.toUpperCase());
		}

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str.toLowerCase());
		}
		System.out.println();

		ListIterator<String> listIt = myList.listIterator(myList.size());
		while (listIt.hasPrevious()) {
			String str = listIt.previous();
			System.out.println(str.toLowerCase());
		}
		System.out.println();

		Collections.sort(myList);
		System.out.println(myList);
	}
}
