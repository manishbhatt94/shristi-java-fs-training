package com.list.comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ProductCompare {

	public static void main(String[] args) {

		Product product1 = new Product("mobile", 10000, "Samsung", 1);
		Product product2 = new Product("pen", 100, "Classmate", 2);
		Product product3 = new Product("headphones", 3000, "Samsung", 3);
		Product product4 = new Product("laptop", 88000, "Dell", 4);
		Product product5 = new Product("mobile", 10000, "Samsung", 1);

		// add to a list
		ArrayList<Product> mylist = new ArrayList<>();
		mylist.add(product1);
		mylist.add(product2);
		mylist.add(product3);
		mylist.add(product5);
		mylist.add(product4);
		mylist.forEach(System.out::println);
		System.out.println();

		// the list must implement Comparable
		Collections.sort(mylist);
		mylist.forEach(System.out::println); // sorted
		System.out.println();

		LinkedList<Product> linklist = new LinkedList<>();
		linklist.add(product1);
		linklist.add(product2);
		linklist.add(product3);
		linklist.add(product5);
		linklist.add(product4);
		linklist.forEach(System.out::println);
		System.out.println();

		HashSet<Product> hashproducts = new HashSet<Product>();
		hashproducts.add(product4);
		hashproducts.add(product5);
		hashproducts.add(product1);
		hashproducts.add(product3);
		hashproducts.add(product2);
		hashproducts.forEach(System.out::println);
		System.out.println();

		// to add to TreeSet the class must implement comparable
		TreeSet<Product> products = new TreeSet<Product>();
		products.add(product4);
		products.add(product2);
		products.add(product3);
		products.add(product5);
		products.add(product1);
		products.forEach(System.out::println);

	}

}
