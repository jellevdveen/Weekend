package com.weekendopdracht.product;

import java.util.ArrayList;



public abstract class Stock {
	// in de arraylist Stock.stockList zijn alle products opgeslagen 
	private static ArrayList<Product> stockList = new ArrayList<Product>();
	private static final int MAX_AMOUNT = 9999;
	
		
	// getter
	public static ArrayList<Product> getFullStock() {
		return stockList;
	}
	
	
	
	// voegt een aantal toe aan een product als het in de lijst staat. Maakt een nieuw product als dit niet zo is
	public static void addTo(String name, int amount, int costPerUnit, String type) {
		if (amount > MAX_AMOUNT) {
			System.out.println("Maximal stock of 9999 exceeded, stock set to 9999");
			amount = MAX_AMOUNT;
		}
		
		for (Product p : stockList) {
			if (p.getName().equals(name)) {
				if (p.getStock() + amount <= MAX_AMOUNT) {
					try {
						p.setStock(p.getStock() + amount);
					} catch (IllegalArgumentException IAE) {
						System.out.println("Cannot set item stock to a negative value.");
						amount = 0;
					}
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
			try{
				stockList.add(new DefaultProduct(name, amount, costPerUnit));
			} catch (IllegalArgumentException IAE) {
				System.out.println("Cannot set item stock to a negative value.");
				amount = 0;
			}
		}
	}
	
	// length unit needs to be implemented
	public static void print(int lengthName, int lengthCost, int lengthUnit, int lengthAmount) {
		int counter = 0;
		for (Product p : Stock.getFullStock()) {
			counter++;
			System.out.println(counter + ") " + p.toString(lengthName - 3, lengthCost, lengthUnit, lengthAmount));
		}
	}
}