package com.weekendopdracht.main;

import com.weekendopdracht.product.Product;
import com.weekendopdracht.product.Stock;

public class Main {

	public static void main(String[] args) {
		
		
		// seems to work fine, some examples
		Stock.addTo("Appels", 10, "Default");
		Stock.addTo("Bananen", 10, "Default");
		
		printFormattedList(30);
		
		
		Stock.addTo("Appels", 10, "Default");
		
		printFormattedList(30);

	}
	
	private static void printFormattedList(int lengthOfProductName) {
		for (Product p : Stock.getFullStock()) {
			String formattedName = p.getName();
		
				for (int i = 0; i + p.getName().length() < lengthOfProductName; i++) {
					formattedName = formattedName.concat(" ");
				}
				System.out.println(formattedName + p.getStock());
		}
	}

}
