package com.weekendopdracht.product;

import java.util.ArrayList;

import com.weekendopdracht.exception.NegativeValueException;



public abstract class Stock {
	// in de arraylist Stock.stockList zijn alle products opgeslagen 
	private static ArrayList<Product> stockList = new ArrayList<Product>();
	private static final int MAX_AMOUNT = 9999;
	
		
	// getter
	public static ArrayList<Product> getFullStock() {
		return stockList;
	}
	
	
	
	// voegt een aantal toe aan een product als het in de lijst staat. Maakt een nieuw product als dit niet zo is
	public static void addTo(String name, int amount, int costPerUnit, int unit, String type) {
		if ((amount < 0) || (costPerUnit < 0)) {
			System.out.println("Negatieve prijs/hoeveelheid niet toegestaan");
			return;
		}
		// for loop die naar bekende producten zoekt
		for (Product p : stockList) {
			if (p.getName().equals(name)) {
				if (p.getStock() + amount <= MAX_AMOUNT) {
					try {
						p.setStock(p.getStock() + amount);
					} catch (NegativeValueException NVE) {
						System.out.println(NVE.getMessage() + " (" + p.getName() + ")");
						amount = 0;
					}
				} else {
					System.out.println("Maximale vooraad van 9999 overschreden, naar 9999 gezet");
					amount = MAX_AMOUNT;
				}
				
				return;
			}
		}
		
		
		if (amount > MAX_AMOUNT) {
			System.out.println("Maximale vooraad van 9999 overschreden, naar 9999 gezet");
			amount = MAX_AMOUNT;
		}
		
		
		// maakt nieuw product
		try{
			if (type.equals("Bulk Discount")) {
				// add Bulk Discount product subclass
			} else if (type.equals("Limited Quantity")){
				// add Limited Quantity product subclass
			} else {
				stockList.add(new DefaultProduct(name, amount, costPerUnit, unit));
			} 
		}	catch (NegativeValueException NVE) {
			System.out.println(NVE.getMessage());
			amount = 0;
		}
	}
	
	
	// overloaded method voor als er geen unit wordt meegegeven
	public static void addTo(String name, int amount, int costPerUnit, String type) {
		addTo(name, amount, costPerUnit, 1, type);
	}
	
	public static void addTo(String name, int amount, int costPerUnit) {
		addTo(name, amount, costPerUnit, 1, "Default");
	}
	
	
	
	
	
	public static void print(int lengthName, int lengthCost, int lengthUnit, int lengthAmount) {
		int counter = 0;
		for (Product p : Stock.getFullStock()) {
			counter++;
			System.out.println(counter + ") " + p.toString(lengthName - 3, lengthCost, lengthUnit, lengthAmount));
		}
	}
}