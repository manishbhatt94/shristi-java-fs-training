package com.threads.extending;

class Child extends Thread {

	String name;

	public Child(String name, int priority) {
		super(name);
		this.name = name;
		this.setPriority(priority);
		this.start();
	}

	@Override
	public void run() {
		System.out.println("Current thread: " + name);
		System.out.println("In run method");
	}
}

public class ExtendedThreadMain {

	public static void main(String[] args) {
		Child t1 = new Child("Thread-1", Thread.MAX_PRIORITY - 1);
		Child t2 = new Child("Thread-2", Thread.MAX_PRIORITY - 1);
		Child t3 = new Child("Thread-3", Thread.MAX_PRIORITY - 1);
	}
}
