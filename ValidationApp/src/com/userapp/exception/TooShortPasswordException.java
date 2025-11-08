package com.userapp.exception;

public class TooShortPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public TooShortPasswordException() {
		super();
	}

	public TooShortPasswordException(String message) {
		super(message);
	}
}
