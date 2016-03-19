package com.weekendopdracht.main;

import com.weekendopdracht.order.Cart;
import com.weekendopdracht.product.Stock;

public class Main {

	public static void main(String[] args) {
		
		
		/* seems to work fine, some examples.. maximum amount is 9999 as defined in Stock class, so
		 * maximum length of the amount part is 4 characters 
		 */
		Stock.addTo("Appel", 224, 5, "Default");
		Stock.addTo("Bungeejumptouw", 46, 6, "Default");
		
		Stock.addTo("Appel", 3472, 6, "Default");
		Stock.addTo("Cello", 81, 100, "Default");
		
		
		printFormattedStockList(30, 10, 10, 15);
		
		if (!Cart.order(Stock.getFullStock().get(1), 2)) {
			System.out.println("Order failed, not enough items in stock.");
		}
		if (!Cart.order(Stock.getFullStock().get(2), 67)) {
			System.out.println("Order failed, not enough items in stock.");
		}
		
		printCart(30, 15, 10);
		

	}
	
	/* function that shows/will show the full stock in an eye-pleasing way..
	 * the method parameters represent the width of the columns
	 */
	private static void printFormattedStockList(int lengthOfProductName, int lengthCost, int lengthUnit, int lengthAmount) {
		drawLine(lengthOfProductName + lengthCost + lengthUnit + lengthAmount);
		
		String tempString = "Naam product";
		
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
	
	private static void printCart(int lengthName, int lengthAmount, int lengthCost){
		System.out.println("Winkelwagentje");
		drawLine(lengthName + lengthAmount + lengthCost);
		Cart.printOrders(lengthName, lengthAmount, lengthCost);
		drawLine(lengthName + lengthAmount + lengthCost);
		Cart.printTotal(lengthName, lengthAmount);
	}
	
	private static void drawLine(int length){
		String tempString = "";
		for (int i = 0; i < length; i++) {
			tempString = tempString.concat("-");
		}
		System.out.println(tempString);
	}

}
