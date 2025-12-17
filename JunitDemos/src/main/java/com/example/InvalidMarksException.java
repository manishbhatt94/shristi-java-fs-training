package com.example;

public class InvalidMarksException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMarksException() {
		super();
	}

	public InvalidMarksException(String message) {
		super(message);
	}

}
