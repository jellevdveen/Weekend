package com.weekendopdracht.product;

public class DefaultProduct extends Product {
	private String name;
	private int stock;
	
	// constructor(s)
	public DefaultProduct(String name, int stock) {
		super(name, stock);
	}
	
	
	
	
	// setters
	
	// perhaps default access would suffice
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	void setName(String name) {
		this.name = name;
	}
		
	
	
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return stock; 
	}

	
}
