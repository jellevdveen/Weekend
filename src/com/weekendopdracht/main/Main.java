package com.weekendopdracht.main;

import java.util.Scanner;

import com.weekendopdracht.order.Cart;
import com.weekendopdracht.product.Stock;

public class Main {

	public static void main(String[] args) {
		
		
		/* seems to work fine, some examples.. maximum amount is 9999 as defined in Stock class, so
		 * maximum length of the amount part is 4 characters 
		 */
		
		// in de arraylist Stock.stockList zijn alle products opgeslagen, hier worden er wat producten toegevoegd
		// als we tijd teveel hebben kunnen we hier ook een user interface voor maken
		Stock.addTo("Appel", 224, 600, 2, "Default");
		Stock.addTo("Bungeejumptouw", 46, 500, 4, "Default");
		
		Stock.addTo("Appel", -22, 6, "Default");
		Stock.addTo("Cello", 81, 5000, "Default");
		
		
		Scanner inputScanner = new Scanner(System.in);
		Cart cart1 = new Cart();
		
		System.out.println(askOrder(0, inputScanner));	
		
		
		/* hier worden als test wat producten besteld... hiervoor moet dus een user interface worden gemaakt
		 * waarin de user een nummer (geprint door bovenstaande method printFormattedStockList) invoert en
		 * aan de hand van dit nummer (min één, want stock.stockList is zero-based) een product wordt 
		 * opgezocht in de stockList en deze wordt doorgegeven aan Cart.order, waar het in de winkelwagen
		 * wordt gezet
		 */
		
		System.out.println("\n");
		
		
		
		
		cart1.order(Stock.getFullStock().get(0), 2);
		cart1.order(Stock.getFullStock().get(0), -67);
		cart1.order(Stock.getFullStock().get(1), 67);
		
		System.out.println("\n");
		
		// dit print een netjes geformatteerd bestelwagentje
		printCart(cart1, 30, 15, 15);
		
		inputScanner.close();

	}
	
	/* function that shows/will show the full stock in an eye-pleasing way..
	 * -------    the method parameters represent the width of the columns!!!!       -----------------
	 */
	private static void printFormattedStockList(int lengthOfProductName, int lengthCost, int lengthUnit, int lengthAmount) {
		drawLine(lengthOfProductName + lengthCost + lengthUnit + lengthAmount);
		
		String tempString = "Naam product";
		
		while (tempString.length() < lengthOfProductName) {
			tempString = (tempString + " ");
		}
		tempString = (tempString + "Prijs (ex. BTW)");
		
		while (tempString.length() < lengthOfProductName + lengthCost + lengthUnit) {
			tempString = (tempString + " ");
		}
		tempString = (tempString + "Voorraad");
		
		while (tempString.length() < lengthOfProductName + lengthCost + lengthUnit + lengthAmount) {
			tempString = (tempString + " ");
		}
		System.out.println(tempString);
		
		drawLine(tempString.length());
		Stock.print(lengthOfProductName, lengthCost, lengthUnit, lengthAmount);
		drawLine(tempString.length());
	}
	
	private static void printCart(Cart cart, int lengthName, int lengthAmount, int lengthCost){
		String tempString = "Winkelwagentje";
		while (tempString.length() < lengthName + lengthAmount) {
			tempString = tempString + " ";
		}
		
		tempString = tempString + "Prijs (ex. BTW)";
		
		
		System.out.println(tempString);
		drawLine(lengthName + lengthAmount + lengthCost);
		cart.printOrders(lengthName, lengthAmount, lengthCost);
		drawLine(lengthName + lengthAmount + lengthCost);
		cart.printTotal(lengthName, lengthAmount);
	}
	
	
	//draws a line made up of -s
	private static void drawLine(int length){
		String tempString = "";
		for (int i = 0; i < length; i++) {
			tempString = tempString.concat("-");
		}
		System.out.println(tempString);
	}

	private static String askQuestion(String question, Scanner s) {
		System.out.println(question);
		String answer = "";
		answer = s.next();
		return answer;
		
	}

	private static String askOrder(int counter, Scanner inputScanner) {
		if (counter % 4 == 0) {
			printFormattedStockList(40, 10, 20, 15);
		}
		String answer = askQuestion("What do you want to order? (1-" + Stock.getFullStock().size() + ")\nToets Q om af te sluiten of W om naar winkelwagentje te gaan.", inputScanner);
		try {
			if (answer.equals("q") || answer.equals("Q")) {
				return "Quit";			
			} else if (answer.equals("w") || answer.equals("W")) {
				return "Cart";
			} else if ((0 < Integer.parseInt(answer)) && (Integer.parseInt(answer) <= Stock.getFullStock().size())) {
				return answer;
			} else {
				counter++;
				System.out.println("Geen geldig antwoord!");
				return askOrder(counter, inputScanner);
			}
		} catch (NumberFormatException NFE) {
			counter++;
			System.out.println("Geen geldig antwoord!");
			return askOrder(counter, inputScanner);
		}
	}
	
	
}