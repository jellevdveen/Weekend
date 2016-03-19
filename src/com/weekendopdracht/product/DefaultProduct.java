package com.weekendopdracht.product;

public class DefaultProduct extends Product {
	private String name;
	private int stock;
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return stock; 
	}

	// setters
	
	// perhaps default access would suffice
	public void setStock(int stock) {
		this.stock = stock;
	}
}
