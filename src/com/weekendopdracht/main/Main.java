package com.weekendopdracht.main;

import com.weekendopdracht.product.Product;
import com.weekendopdracht.product.Stock;

public class Main {

	public static void main(String[] args) {
		
		
		// seems to work fine, some examples
		Stock.addTo("Appels", 10, "Default");
		Stock.addTo("Bananen", 10, "Default");
		
		Stock.addTo("Appels", 10, "Default");
		Stock.addTo("Altviolen", 10, "Default");
		
		printFormattedStockList(30);

	}
	
	// function that shows/will show the full stock in an eye-pleasing way
	private static void printFormattedStockList(int lengthOfProductName) {
		drawLine(lengthOfProductName + 11);
		
		String tempString = "Productnaam";
		
		for (int i = 0; i + 11 < lengthOfProductName; i++) {
			tempString = tempString.concat(" ");
		}
		System.out.println(tempString + "Hoeveelheid");
		
		
		drawLine(lengthOfProductName + 11);
		
		
		for (Product p : Stock.getFullStock()) {
			tempString = p.getName();
		
			for (int i = 0; i + p.getName().length() < lengthOfProductName; i++) {
				tempString = tempString.concat(" ");
			}
			System.out.println(tempString + p.getStock());
		}
		
		drawLine(lengthOfProductName + 11);
	}
	
	private static void drawLine(int length){
		String tempString = "";
		for (int i = 0; i < length; i++) {
			tempString = tempString.concat("-");
		}
		System.out.println(tempString);
	}

}
