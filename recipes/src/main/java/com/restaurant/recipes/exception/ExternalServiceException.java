package com.restaurant.recipes.exception;

public class ExternalServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ExternalServiceException(String message) {
	    super(message);
	 }
}
