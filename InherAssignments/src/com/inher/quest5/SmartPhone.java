package com.inher.quest5;

public class SmartPhone extends Mobile {

	@Override
	void call() {
		System.out.println("Calling from Smart Phone");
	}

	String[] apps() {
		return new String[] { "Reddit", "TrueCaller", "Uber" };
	}
}
