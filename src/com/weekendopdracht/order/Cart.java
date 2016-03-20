package com.weekendopdracht.order;

import java.util.ArrayList;

import com.weekendopdracht.exception.NegativeValueException;
import com.weekendopdracht.exception.StockExceededException;
import com.weekendopdracht.product.Product;

// this class needs to make sure the placed ProductOrder is valid

public class Cart {
	private ArrayList<ProductOrder> shoppingList = new ArrayList<ProductOrder>();
	
	public int getTotalCost(boolean taxIncluded) {
		int totalCost = 0;
		for (ProductOrder p : this.shoppingList) {
			totalCost += p.getCost(taxIncluded);
		}
		return totalCost;
	}
	

	public boolean order(Product p, int amount){
		
		
		try {
			p.takeFromStock(amount);
			for (ProductOrder po : this.shoppingList){
				if (po.getProductName().equals(p.getName())) {
					po.setOrderAmount(po.getOrderAmount() + amount);
					return true;
				}
			}
			this.shoppingList.add(new ProductOrder(p, amount));
			return true;
		} catch (NegativeValueException NVE) {
			System.out.println(NVE.getMessage() + " (" + p.getName() + ")");
			return false;
		} catch (StockExceededException SEE) {
			System.out.println(SEE.getMessage() + " (" + p.getName() + ")");
			return false;
		}
		
		
		
	}
	
	public void printOrders(int lengthName, int lengthAmount, int lengthCost) {
		for (ProductOrder p : this.shoppingList) {
			System.out.println(p.toString(lengthName, lengthAmount, lengthCost));
		}
	}
	
	public void printTotal(int lengthName, int lengthAmount) {
		String total = "Totaal (ex. BTW)";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(this.getTotalCost(false)));
		
		total = "BTW";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(this.getTotalCost(true) - this.getTotalCost(false)));
		
		total = "Totaal";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(this.getTotalCost(true)));	
	}
}
