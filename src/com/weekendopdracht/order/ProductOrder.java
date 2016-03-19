package com.weekendopdracht.order;

import com.weekendopdracht.product.Product;

public class ProductOrder {
	private Product orderProduct;
	private int orderAmount;
	
	// for testing purposes set to 10
	private int cost = 10;
	
	
	ProductOrder(Product p, int amount) {
		this.orderProduct = p;
		this.orderAmount = amount;
	}
	
	public int getCost(boolean taxIncluded) {
		return cost;
	}
	
	public String toString(int lengthName, int lengthAmount, int lengthCost) {
		String tempString = this.orderProduct.getName();
		
		while (tempString.length() < lengthName) {
			tempString = (tempString + " ");
			
		}
		
		tempString = tempString + Integer.toString(this.orderAmount);
		
		while (tempString.length() < (lengthName + lengthAmount)) {
			tempString = (tempString + " ");
		}
		
		tempString += Integer.toString((getCost(false)));
		while (tempString.length() < (lengthName + lengthCost + lengthAmount)) {
			tempString = (tempString + " ");
		}

		return tempString;
	}
}
