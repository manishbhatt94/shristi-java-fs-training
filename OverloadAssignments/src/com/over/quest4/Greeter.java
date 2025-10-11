package com.over.quest4;

public class Greeter {

	String name;

	public Greeter(String name) {
		this.name = name;
	}

	public Greeter() {
	}

	void greetUser(String... messages) {
		System.out.println("Greeting user: " + name + "!");
		for (String message : messages) {
			System.out.println(message + " " + name);
		}
		System.out.println();
	}

	void sayHello(String... names) {
		System.out.println("Welcoming few users:");
		for (String name : names) {
			System.out.println("Welcome, " + name + "!");
		}
		System.out.println();
	}
}
