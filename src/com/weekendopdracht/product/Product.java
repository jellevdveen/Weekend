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
	protected abstract int getStock();
	public abstract int getCostPerUnit();
	protected abstract int getTaxPercentage();
	
	
	public int getCost(int amount, boolean taxIncluded) {
		int cost;
		if (!taxIncluded){
			cost = (amount * getCostPerUnit());
		} else {
			cost = ((amount * getCostPerUnit()*119)/100);
		}
		
		return cost;
	}
	
	public int getCost(int amount) {
		return getCost(amount, true);
	}
	public int getCost() {
		return getCostPerUnit();
	}
	
	
	// setters
	
		
	public final void setStock(int stock) throws IllegalArgumentException {
		if (stock < 0) {
			throw new IllegalArgumentException();
		} else {
			setStockTo(stock);
		}
	}
	public abstract void setStockTo(int stock);
	// without a setName function, having a name input in the constructor is utterly useless
	abstract void setName(String name);
	abstract void setCostPerUnit(int costPerUnit);
	
	
	
	
	public boolean takeFromStock(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException();
		} else if (amount < getStock()) {
			setStock(getStock() - amount);
			return true;
		}
		return false;
	}
	
	
	public String toString(int lengthName, int lengthCost, int lengthUnit, int lengthAmount) {
		String tempString = getName();
		
		while (tempString.length() < lengthName) {
			tempString = (tempString + " ");
			
		}
		
		tempString = tempString + Integer.toString(getCostPerUnit());
		
		while (tempString.length() < (lengthName + lengthCost + lengthUnit)) {
			tempString = (tempString + " ");
		}
		
		tempString += Integer.toString((getStock()));
		while (tempString.length() < (lengthName + lengthCost + lengthAmount)) {
			tempString = (tempString + " ");
		}
		
		return tempString;
	}
	
	
		
}
