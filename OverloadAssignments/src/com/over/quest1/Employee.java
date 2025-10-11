package com.over.quest1;

import java.util.List;

public class Employee {

	String name;
	String designation;

	static final List<String> validDesignations = List.of("programmer", "manager", "director");

	public Employee(String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}

	void printInfo() {
		System.out.println("Name: " + name + " (Designation: " + designation + ")");
	}

	void calcBonus(double basicAllowance) {
		double bonus = basicAllowance * 0.25;
		System.out.println(String.format("Bounus = ₹%.2f", bonus));
	}

	void calcBonus(double basicAllowance, String gift) {
		double bonus = basicAllowance * 0.25;
		System.out.println(String.format("Bounus = ₹%.2f", bonus));
		System.out.println("Plus gift: " + gift);
	}

	void calcBonus(double basicAllowance, String gift, double houseAllowance) {
		double bonus = basicAllowance * 0.25 + houseAllowance * 0.80;
		System.out.println(String.format("Bounus = ₹%.2f", bonus));
		System.out.println("Plus gift: " + gift);
	}
}
