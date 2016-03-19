package com.weekendopdracht.product;

public abstract class Product {
	
	
	// Constructors
	
	Product(String name, int stock, int costPerUnit) {
		setStock(stock);
		setName(name);
		setCostPerUnit(costPerUnit);
		
	}
	
	//getters
	public abstract String getName();
	public abstract int getStock();
	public abstract int getCostPerUnit();
	
	
	
	// setters
	
		
	/* according to the assignment setStock should be defined here, but I don't see how, as Product class
	does not have any instance variables according to the same assignment*/
	public abstract void setStock(int stock);
	// without a setName function, having a name input in the constructor is utterly useless
	abstract void setName(String name);
	abstract void setCostPerUnit(int costPerUnit);
	
	
	
	
	public void takeFromStock(int amount) {
		setStock(getStock() - amount);
	}
	
	
		
}
