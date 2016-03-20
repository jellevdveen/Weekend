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
		
		menuOrder(inputScanner, cart1);
		
		
		
		
		

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
		String answer = askQuestion("Wat wil je bestellen? (1-" + Stock.getFullStock().size() + ")\nToets Q om af te sluiten of W om naar winkelwagentje te gaan.", inputScanner);
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
	
	private static void menuOrder(Scanner inputScanner, Cart cart) {
		String choice = (askOrder(0, inputScanner));	
		try {
			switch (choice){
			case "Quit"	:	System.exit(0);
							break;
			case "Cart" :	menuCart(inputScanner, cart);
							break;
			default		:	cart.order(Stock.getFullStock().get(Integer.valueOf(choice) - 1), Integer.valueOf(askQuestion("Hoeveel?", inputScanner)));
							menuCart(inputScanner, cart);
			}
		} catch (NumberFormatException NFE) {
			System.out.println("Geen geldige hoeveelheid");
			menuOrder(inputScanner, cart);
		}
	}
	
	
	private static String askCart(int counter, Scanner inputScanner, Cart cart) {
		if (counter % 4 == 0) {
			printCart(cart, 30, 20, 15);
		}
		String answer = askQuestion("Wat wil je doen? Orderhoeveelheid aanpassen (A),\nAndere producten bestellen (B), Order versturen (V) of afsluiten (Q)?", inputScanner);
		if (answer.equals("a") || answer.equals("A")) {
			return "Change";			
		} else if (answer.equals("b") || answer.equals("B")) {
			return "Order";
		} else if (answer.equals("v") || answer.equals("V")) {
			return "Send";
		} else if (answer.equals("q") || answer.equals("Q")) {
			return "Quit";
		} else {
			counter++;
			System.out.println("Geen geldig antwoord!");
			return askCart(counter, inputScanner, cart);
		}
	}

	private static void changeCart(int counter, Scanner inputScanner, Cart cart) {
		try {
			if (counter % 4 == 0) {
				printCart(cart, 30, 20, 15);
			}
			int productChoice = Integer.valueOf(askQuestion("Van welk product wil je bestelling wijzigen? (1 - " + cart.getSize() + ")", inputScanner));
			if ((productChoice > 0) && (productChoice < Stock.getFullStock().size())){
				int targetValue = Integer.valueOf(askQuestion("Naar welk aantal wil je deze bestelling veranderen?", inputScanner));
				if (targetValue >= 0) {
					cart.change(productChoice, targetValue);
				} else {
					counter++;
					System.out.println("Geen geldig antwoord!");
					changeCart(counter, inputScanner, cart);
				}
			} else {
				counter++;
				System.out.println("Geen geldig antwoord!");
				changeCart(counter, inputScanner, cart);
			}
			
			
			
			
		} catch (NumberFormatException NFE) {
			counter++;
			System.out.println("Geen geldig antwoord!");
			changeCart(counter, inputScanner, cart);
		}
	}
	
	private static void menuCart(Scanner inputScanner, Cart cart) {
		String choice = (askCart(0, inputScanner, cart));	
		switch (choice){
		case "Quit"	:	System.exit(0);
						break;
		case "Send" :	System.out.println("Dank voor uw bestelling");
						System.exit(0);
						break;
		case "Order":	menuOrder(inputScanner, cart);
						break;
		case "Change":	if (cart.getSize() > 0) {
							changeCart(0, inputScanner, cart);
						} else {
							System.out.println("Geen objecten in winkelwagen");
						}
						menuCart(inputScanner, cart);
						break;
		default		:	System.out.println("Onbekende fout!");
						System.exit(0);
						break;
		}
	}
}