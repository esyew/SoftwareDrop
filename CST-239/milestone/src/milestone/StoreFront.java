package milestone;

import java.text.DecimalFormat;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
public class StoreFront {
	
	
	// This class is used mostly to handle the cart, and does not store data.
public static void getCartInfo(ShoppingCart shoppingCart) {
	//Using https://github.com/kandicst/Java-Console-Table
	//StoreFront.clearWindow();
		String[] headers = {"Index","Product Name", "Item Price", "Num in Cart"};
	    Table inventoryTable = new Table(headers);
	    
	    
	    
	    
	    for (int i = 0; i < shoppingCart.getShoppingCart().size(); i++) {
	    	
	    	
	    	// TODO Temp, hide canceled purchases from the ShoppingCart, hopefully will be fixed. But works for now.
	    	// This could be giving hiding factor of a negative sum, as it makes that harder to diagonose.
	    	
	    	if (shoppingCart.getShoppingCart().get(i).getItemQuantity() > 0) {
	    		inventoryTable.addRow(new String[] {String.valueOf(i + 1), shoppingCart.getShoppingCart().get(i).getItemName(), "$" + String.valueOf(shoppingCart.getShoppingCart().get(i).getItemPrice()), String.valueOf(shoppingCart.getShoppingCart().get(i).getItemQuantity())});

	    	} 
	    	
	    		    	
	    }
	    final DecimalFormat df = new DecimalFormat("#.##");
	   
	    
	    
	    inventoryTable.addRow(new String[] {"","","Sum: $"+ String.valueOf(df.format(shoppingCart.getTotalCost(shoppingCart))),""});
	    
	    // Display inventory to the user
	    inventoryTable.show();
	}

public static void DisplayInventory(ArrayList<Product> inventory) {
	//Using https://github.com/kandicst/Java-Console-Table
	
	String[] headers = {"Index","Product Name", "Price", "Category", "Num in Stock"};
    Table inventoryTable = new Table(headers);
    
    
    for (int i = 0; i < inventory.size(); i++) {
    	inventoryTable.addRow(new String[] {String.valueOf(i + 1), inventory.get(i).getItemName(), "$" + String.valueOf(inventory.get(i).getItemPrice()), inventory.get(i).getItemCategory(), String.valueOf(inventory.get(i).getItemQuantity())});
    }

    
    
    inventoryTable.show();
		
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
		
		
		

		return false;
		
	}

	

}

