package com.weekendopdracht.product;

public class DefaultProduct extends Product {
	private String name;
	private int stock;
	private int costPerUnit;
	private int taxPercentage = 19;
	
	// constructor(s)
	public DefaultProduct(String name, int stock, int costPerUnit) {
		super(name, stock, costPerUnit);
	}
	
	
	
	
	// setters
	
	// perhaps default access would suffice
	public void setStockTo(int stock) {
		this.stock = stock;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
		
	
	
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return this.stock; 
	}
	
	public int getCostPerUnit() {
		return this.costPerUnit;
	}
	
	public int getTaxPercentage() {
		return this.taxPercentage;
	}

	
}
