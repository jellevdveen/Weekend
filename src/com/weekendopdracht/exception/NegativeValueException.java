package com.weekendopdracht.exception;

public class NegativeValueException extends Exception {
	/**
	 * java wants this UID
	 */
	private static final long serialVersionUID = 1L;
	

	public NegativeValueException() {};
	
	public NegativeValueException(String message) {
		super(message);
	}


}
