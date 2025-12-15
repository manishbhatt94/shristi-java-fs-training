package com.productapp.exceptions;

public class ProductsNotFoundForCriteriaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductsNotFoundForCriteriaException() {
		super();
	}

	public ProductsNotFoundForCriteriaException(String message) {
		super(message);
	}

}
