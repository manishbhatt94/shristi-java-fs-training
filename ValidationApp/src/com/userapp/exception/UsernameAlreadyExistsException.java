package com.userapp.exception;

public class UsernameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException() {
		super();
	}

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}
