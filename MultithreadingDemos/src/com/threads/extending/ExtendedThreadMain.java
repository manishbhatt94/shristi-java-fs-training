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
		Child t1 = new Child();
		t1.setName("Thread-1");
		t1.setPriority(Thread.MAX_PRIORITY - 1);
		t1.start();

		Child t2 = new Child();
		t2.setName("Thread-2");
		t2.setPriority(Thread.MAX_PRIORITY - 1);
		t2.start();

		Child t3 = new Child();
		t3.setName("Thread-3");
		t3.setPriority(Thread.MAX_PRIORITY - 1);
		t3.start();
	}
}
