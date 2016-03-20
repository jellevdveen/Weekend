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
	
	public int getSize() {
		return shoppingList.size();
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
	
	public void remove(ProductOrder p, int amount){
		if (p.getOrderAmount() - amount <= 0) {
			this.shoppingList.remove(p);
		} else {
			p.setOrderAmount(p.getOrderAmount() - amount);
		}
		
		
	}
	
	public void change(int productID, int amount){
		if (amount < this.shoppingList.get(productID - 1).getOrderAmount()) {
			this.remove(this.shoppingList.get(productID - 1), this.shoppingList.get(productID - 1).getOrderAmount() - amount);
		} else if (amount > this.shoppingList.get(productID - 1).getOrderAmount()) {
			this.order(this.shoppingList.get(productID - 1).getOrderProduct(), (amount - this.shoppingList.get(productID - 1).getOrderAmount()));
		}
	}
	
	
	
	
	public void printOrders(int lengthName, int lengthAmount, int lengthCost) {
		int counter = 0;
		for (ProductOrder p : this.shoppingList) {
			counter++;
			System.out.println(counter + ") " + p.toString(lengthName-3, lengthAmount, lengthCost));
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
