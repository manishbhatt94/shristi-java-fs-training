package com.threads.extending;

class Child extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("In run method");
	}
}

public class ExtendedThreadMain {

	public static void main(String[] args) {
		Child t = new Child();
		t.setName("Thread-1");
		t.setPriority(Thread.MAX_PRIORITY - 1);
		t.start();
		t.run();
	}
}
