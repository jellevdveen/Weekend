package com.weekendopdracht.product;

import com.weekendopdracht.exception.NegativeValueException;

public class DefaultProduct extends Product {
	private String name;
	private int stock;
	private int costPerUnit;
	private int taxPercentage = 19;
	private String unitName;
	
	// constructor(s)
	public DefaultProduct(String name, int stock, int costPerUnit) throws NegativeValueException {
		super(name, stock, costPerUnit);
	}
	public DefaultProduct(String name, int stock, int costPerUnit, int unit) throws NegativeValueException {
		super(name, stock, costPerUnit, unit);
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
	
	void setUnitName(int unitID) {
		switch (unitID) {
		case gram	:	this.unitName = "gram";
						break;
		case kilo	:	this.unitName = "kilo";
						break;
		case liter	:	this.unitName = "liter";
						break;
		case pak	:	this.unitName = "pak";
						break;
		case stuk	:	
		default		:	this.unitName = "stuk";
						
		}
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

	public String getUnitName() {
		return this.unitName;
	}
	
}
