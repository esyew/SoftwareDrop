package milestone;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class StoreFront {
	
public static void getCartInfo(ArrayList<Product> shoppingCart) {
	//Using https://github.com/kandicst/Java-Console-Table
	//StoreFront.clearWindow();
		String[] headers = {"Index","Product Name", "Item Price", "Num in Cart"};
	    Table inventoryTable = new Table(headers);
	    
	    
	    for (int i = 0; i < shoppingCart.size(); i++) {
	    	inventoryTable.addRow(new String[] {String.valueOf(i + 1), shoppingCart.get(i).getItemName(), "$" + String.valueOf(shoppingCart.get(i).getItemPrice()), String.valueOf(shoppingCart.get(i).getItemQuantity())});
	    	
	    }
	    final DecimalFormat df = new DecimalFormat("#.##");
	   
	    
	    
	    inventoryTable.addRow(new String[] {"","","Sum: $"+ String.valueOf(df.format(sumTotal(shoppingCart))),""});
	    inventoryTable.show();
	}

public static void DisplayInventory(ArrayList<Product> inventory) {
	//Using https://github.com/kandicst/Java-Console-Table
	
	String[] headers = {"Index","Product Name", "Price", "Category", "Num in Stock"};
    Table inventoryTable = new Table(headers);
    
    
    for (int i = 0; i < inventory.size(); i++) {
    	inventoryTable.addRow(new String[] {String.valueOf(i + 1), inventory.get(i).getItemName(), "$" + String.valueOf(inventory.get(i).getItemPrice()), inventory.get(i).getItemCategory(), String.valueOf(inventory.get(i).getItemQuantity())});
    }
    //table.addRow(new String[] {"Lebron", "James", "LAL"});
    
    
    inventoryTable.show();
		
	}

	
	
	
	public static double sumTotal(ArrayList<Product> shoppingCart) {
		double sumTotal = 0.0;
		
		for (int i = 0; i < shoppingCart.size(); i++) {
			sumTotal = sumTotal + (shoppingCart.get(i).getItemPrice() * shoppingCart.get(i).getItemQuantity());
		}
		
		
		
		return sumTotal;
	}
	
	public static boolean Checkout(double totalCost) {
		totalCost = Math.round(totalCost * 100);
		totalCost = totalCost/ 100;
		  System.out.println("Your total before tax: " + totalCost);
		  //Arizona Sales Tax, reference?
		  double afterTax = totalCost * 1.086;
		  afterTax = Math.round(afterTax * 100);
		  afterTax = afterTax/ 100;
		  System.out.println("Your total after tax: " + afterTax);
		
		System.out.print("\nContinue with Purchase? (type 1) (other int for no): ");
		try (Scanner myObj = new Scanner(System.in)) {
			int userSelection = myObj.nextInt();
			if (userSelection == 1) {
				System.out.println("Order Success!\n Press any key to start new order.");
				myObj.next();
				return true;
			}
		}
		return false;
		
	}

	

}

