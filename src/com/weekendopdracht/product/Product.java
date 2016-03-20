package com.weekendopdracht.product;

import com.weekendopdracht.exception.NegativeValueException;
import com.weekendopdracht.exception.StockExceededException;

public abstract class Product {
	
	
	// Constructors
	
	Product(String name, int stock, int costPerUnit) throws NegativeValueException {
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
	
		
	public final void setStock(int stock) throws NegativeValueException {
		if (stock < 0) {
			throw new NegativeValueException("Cannot set stock to negative amount");
		} else {
			setStockTo(stock);
		}
	}
	public abstract void setStockTo(int stock);
	// without a setName function, having a name input in the constructor is utterly useless
	abstract void setName(String name);
	abstract void setCostPerUnit(int costPerUnit);
	
	
	
	
	public void takeFromStock(int amount) throws NegativeValueException, StockExceededException {
		if (amount < 0) {
			throw new NegativeValueException("Cannot take a negative amount of products from stock.");
		} else if (amount < getStock()) {
			setStock(getStock() - amount);
		} else {
			throw new StockExceededException("Not enough items in stock");
		}
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
