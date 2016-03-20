package com.weekendopdracht.order;

import java.util.ArrayList;

import com.weekendopdracht.exception.NegativeValueException;
import com.weekendopdracht.exception.StockExceededException;
import com.weekendopdracht.product.Product;

// this class needs to make sure the placed ProductOrder is valid

public abstract class Cart {
	private static ArrayList<ProductOrder> shoppingList = new ArrayList<ProductOrder>();
	
	public static int getTotalCost(boolean taxIncluded) {
		int totalCost = 0;
		for (ProductOrder p : shoppingList) {
			totalCost += p.getCost(taxIncluded);
		}
		return totalCost;
	}
	

	public static boolean order(Product p, int amount){
		
		
		try {
			p.takeFromStock(amount);
			for (ProductOrder po : shoppingList){
				if (po.getProductName().equals(p.getName())) {
					po.setOrderAmount(po.getOrderAmount() + amount);
					return true;
				}
			}
			shoppingList.add(new ProductOrder(p, amount));
			return true;
		} catch (NegativeValueException NVE) {
			System.out.println(NVE.getMessage() + " (" + p.getName() + ")");
			return false;
		} catch (StockExceededException SEE) {
			System.out.println(SEE.getMessage() + " (" + p.getName() + ")");
			return false;
		}
		
		
		
	}
	
	public static void printOrders(int lengthName, int lengthAmount, int lengthCost) {
		for (ProductOrder p : shoppingList) {
			System.out.println(p.toString(lengthName, lengthAmount, lengthCost));
		}
	}
	
	public static void printTotal(int lengthName, int lengthAmount) {
		String total = "Totaal (ex. BTW)";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(getTotalCost(false)));
		
		total = "BTW";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(getTotalCost(true) - getTotalCost(false)));
		
		total = "Totaal";
		while (total.length() < (lengthName + lengthAmount)) {
			total = total + " ";
		}
		System.out.println(total + Integer.toString(getTotalCost(true)));	
	}
}
