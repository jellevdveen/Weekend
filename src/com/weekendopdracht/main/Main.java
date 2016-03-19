package com.weekendopdracht.main;

import com.weekendopdracht.product.Stock;

public class Main {

	public static void main(String[] args) {
		
		
		/* seems to work fine, some examples.. maximum amount is 9999 as defined in Stock class, so
		 * maximum length of the amount part is 4 characters 
		 */
		Stock.addTo("Appels", 10, 5, "Default");
		Stock.addTo("Bananen", 10, 6, "Default");
		
		Stock.addTo("Appels", 10, 6, "Default");
		Stock.addTo("Altviolen", 10, 100, "Default");
		
		printFormattedStockList(30, 10, 10, 15);

	}
	
	// function that shows/will show the full stock in an eye-pleasing way
	private static void printFormattedStockList(int lengthOfProductName, int lengthCost, int lengthUnit, int lengthAmount) {
		drawLine(lengthOfProductName + lengthCost + lengthUnit + lengthAmount);
		
		
		// will have to be neater:
		String tempString = "Productnaam";
		
		while (tempString.length() < lengthOfProductName) {
			tempString = (tempString + " ");
		}
		tempString = (tempString + "Prijs");
		
		while (tempString.length() < lengthOfProductName + lengthCost + lengthUnit) {
			tempString = (tempString + " ");
		}
		tempString = (tempString + "Hoeveelheid");
		
		while (tempString.length() < lengthOfProductName + lengthCost + lengthUnit + lengthAmount) {
			tempString = (tempString + " ");
		}
		System.out.println(tempString);
		
		
		
		drawLine(tempString.length());
		
		Stock.print(lengthOfProductName, lengthCost, lengthUnit, lengthAmount);
		
		drawLine(tempString.length());
	}
	
	private static void drawLine(int length){
		String tempString = "";
		for (int i = 0; i < length; i++) {
			tempString = tempString.concat("-");
		}
		System.out.println(tempString);
	}

}
