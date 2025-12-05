package com.set.examples;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {

		Set<String> mySet = new HashSet<>();
		// Set<String> myset = new LinkedHashSet<>();
		// Set<String> myset = new TreeSet<>();
		mySet.add("apple");
		mySet.add("Orange");
		System.out.println(mySet.size());
		System.out.println(mySet);
		mySet.add("kiwi");
		mySet.add("kiwi");
		mySet.add("mango");
		mySet.add(null);
		mySet.add("pineapple");
		mySet.add("papaya");
		System.out.println(mySet);
		System.out.println();

		for (String str : mySet) {
			System.out.println(str);
		}

	}

}
