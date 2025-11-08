package com.userapp.exception;

public class TooLongPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public TooLongPasswordException() {
		super();
	}

	public TooLongPasswordException(String message) {
		super(message);
	}
}
