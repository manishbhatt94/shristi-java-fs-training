package com.threads.impl;

class Runner implements Runnable {

	String name;

	public Runner(String name) {
		super();
		this.name = name;
		Thread thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Hello ");
		Greeter greeter = new Greeter();
		System.out.println(greeter.greetUser(name));
	}
}

public class MainRunDemo {

	public static void main(String[] args) {

		Runner runner1 = new Runner("Runner-1");
		Runner runner2 = new Runner("Runner-2");
		Runner runner3 = new Runner("Runner-3");
	}
}
