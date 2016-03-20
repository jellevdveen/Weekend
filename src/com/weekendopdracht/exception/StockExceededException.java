package com.weekendopdracht.exception;

public class StockExceededException extends Exception {
	/**
	 * java wants this UID
	 */
	private static final long serialVersionUID = 1L;
	

	public StockExceededException() {};
	
	public StockExceededException(String message) {
		super(message);
	}
}
