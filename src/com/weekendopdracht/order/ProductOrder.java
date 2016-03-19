package com.weekendopdracht.order;

import com.weekendopdracht.product.Product;

public class ProductOrder {
	private Product orderProduct;
	private int orderAmount;

	
	ProductOrder(Product p, int amount) {
		this.orderProduct = p;
		this.orderAmount = amount;
	}
		
	
	int getCost(boolean taxIncluded) {
		return (this.orderProduct.getCost(this.orderAmount, taxIncluded));
	}
		
	int getOrderAmount() {
		return orderAmount;
	}
	
	String getProductName() {
		return this.orderProduct.getName();
	}
	
	
	void setOrderAmount(int amount) {
		this.orderAmount = amount;
	}
	
	
	
	
	
	String toString(int lengthName, int lengthAmount, int lengthCost) {
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
