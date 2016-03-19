// perhaps all members here could be inserted as abstract members of the class 'Product'


package com.weekendopdracht.product;

import java.util.ArrayList;



public abstract class Stock {
	private static ArrayList<Product> stockList = new ArrayList<Product>();
	private static final int MAX_AMOUNT = 9999;
	
	
	
	// getter
	public static ArrayList<Product> getFullStock() {
		return stockList;
	}
	
	
	
	
	public static void addTo(String name, int amount, int costPerUnit, String type) {
		if (amount > MAX_AMOUNT) {
			System.out.println("Maximal stock of 9999 exceeded, stock set to 9999");
			amount = MAX_AMOUNT;
		}
		
		for (Product p : stockList) {
			if (p.getName().equals(name)) {
				if (p.getStock() + amount <= MAX_AMOUNT) {
					p.setStock(p.getStock() + amount);
				} else {
					System.out.println("Maximal stock of 9999 exceeded, stock set to 9999");
					amount = MAX_AMOUNT;
				}
				
				return;
			}
		}
		
		
		
		
		
		if (type.equals("Bulk Discount")) {
			// add Bulk Discount product subclass
		} else if (type.equals("Limited Quantity")){
			// add Limited Quantity product subclass
		} else {
			stockList.add(new DefaultProduct(name, amount, costPerUnit));
		}
	}
	
	// length unit needs to be implemented
	public static void print(int lengthName, int lengthCost, int lengthUnit, int lengthAmount) {
		String tempString;
		int counter = 0;
		for (Product p : Stock.getFullStock()) {
			counter++;
			tempString = counter + ") " + p.getName();
	
			while (tempString.length() < lengthName) {
				tempString = (tempString + " ");
				
			}
			
			tempString = tempString + Integer.toString(p.getCostPerUnit());
			
			while (tempString.length() < (lengthName + lengthCost + lengthUnit)) {
				tempString = (tempString + " ");
			}
			
			tempString += Integer.toString((p.getStock()));
			while (tempString.length() < (lengthName + lengthCost + lengthAmount)) {
				tempString = (tempString + " ");
			}

			System.out.println(tempString);
		}
	}
}