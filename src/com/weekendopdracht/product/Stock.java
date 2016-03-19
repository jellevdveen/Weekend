// perhaps all members here could be inserted as abstract members of the class 'Product'


package com.weekendopdracht.product;

import java.util.ArrayList;

public abstract class Stock {
	private static ArrayList<Product> stockList = new ArrayList<Product>();
	
	public static ArrayList<Product> getFullStock() {
		return stockList;
	}
	
	public static void addTo(String name, int amount, String type) {
		for (Product p : stockList) {
			if (p.getName().equals(name)) {
				p.setStock(p.getStock() + amount);
				return;
			}
		}
		
		if (type.equals("Bulk Discount")) {
			
		} else if (type.equals("Limited Quantity")){
			
		} else {
			stockList.add(new DefaultProduct(name, amount));
		}
	}
}