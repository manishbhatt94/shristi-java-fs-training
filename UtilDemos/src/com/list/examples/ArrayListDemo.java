package com.list.examples;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {

		List myList = new ArrayList();
		myList.add("apple");
		myList.add(100);
		myList.add(1.8);
		myList.add("kiwi");
		myList.add(5.6f);
		myList.add(new ArrayListDemo());

		System.out.println(myList);

		for (Object o : myList) {
			String str = (String) o;
			System.out.println(str);
		}
	}
}
