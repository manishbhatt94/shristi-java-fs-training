package com.threads.impl;

class Runner implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello ");
	}
}

public class MainRunDemo {

	public static void main(String[] args) {

		Runner runner = new Runner();
		Thread thread = new Thread(runner, "Runner-1");
		thread.start();
	}
}
