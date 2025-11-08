package com.except.slides.tryresources;

class MyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Closing the resources");
	}

	public void myMethod() {
		System.out.println("Doing some calculation");
	}
}

public class TryWithResourcesDemo {

	public static void main(String[] args) {
		try (MyResource res = new MyResource()) {
			res.myMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
