package com.weekendopdracht.product;

public abstract class Product {
	public abstract String getName();
	public abstract int getStock();
	
	
	/* according to the assignment setStock should be defined here, but I don't see how, as Product class
	does not have any instance variables according to the same assignment*/
	public abstract void setStock(int stock);
	
	public void takeFromStock(int amount) {
		setStock(getStock() - amount);
	}
	
	
		
}
