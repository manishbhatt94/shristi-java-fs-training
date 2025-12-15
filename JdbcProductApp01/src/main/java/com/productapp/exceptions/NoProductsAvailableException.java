package com.productapp.exceptions;

public class NoProductsAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoProductsAvailableException() {
		super();
	}

	public NoProductsAvailableException(String message) {
		super(message);
	}

}
