package com.weekendopdracht.product;

import com.weekendopdracht.exception.NegativeValueException;
import com.weekendopdracht.exception.StockExceededException;

public abstract class Product {
	protected static final int stuk = 0;
	protected static final int gram = 1;
	protected static final int kilo = 2;
	protected static final int liter = 3;
	protected static final int pak = 4;
	
	
	// Constructors
	Product(String name, int stock, int costPerUnit) throws NegativeValueException {
		this(name, stock, costPerUnit, 0);
	}
	
	Product(String name, int stock, int costPerUnit, int unit) throws NegativeValueException {
		setStock(stock);
		setName(name);
		setCostPerUnit(costPerUnit);
		setUnitName(unit);
	}
	
	//getters
	public abstract String getUnitName();
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
	public abstract void setStockTo(int stock);
	// without a setName function, having a name input in the constructor is utterly useless
	abstract void setName(String name);
	abstract void setCostPerUnit(int costPerUnit);
	abstract void setUnitName(int unitID);
		
	public final void setStock(int stock) throws NegativeValueException {
		if (stock < 0) {
			throw new NegativeValueException("Voorraad kan niet negatief worden");
		} else {
			setStockTo(stock);
		}
	}
		
	public void takeFromStock(int amount) throws NegativeValueException, StockExceededException {
		if (amount < 0) {
			throw new NegativeValueException("Kan geen negatief aantal producten uit voorraad halen");
		} else if (amount < getStock()) {
			setStock(getStock() - amount);
		} else {
			throw new StockExceededException("Niet genoeg producten op voorraad");
		}
	}
	
	
	public String toString(int lengthName, int lengthCost, int lengthUnit, int lengthAmount) {
		
		String tempString = getName();
		
		while (tempString.length() < lengthName) {
			tempString = (tempString + " ");
			
		}
		
		tempString = tempString + Integer.toString(getCostPerUnit());
		while (tempString.length() < (lengthName + lengthCost)) {
			tempString = (tempString + " ");
		}
		
		tempString = tempString + "Euro per " + getUnitName();
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
