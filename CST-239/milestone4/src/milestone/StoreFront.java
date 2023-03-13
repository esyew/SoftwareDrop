package milestone;

import java.text.DecimalFormat;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
public class StoreFront {
	
	
	// This class is used mostly to handle the cart, and does not store data.
public static void getCartInfo(ShoppingCart shoppingCart) {
	System.out.println("\nSHOPPING CART");
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





public static void DisplayItem(Product product) {
	
	
	String[] headers = {"    ", product.getItemName()};
    Table inventoryTable = new Table(headers);
    
    
    //Create product table
    	inventoryTable.addRow(new String[] {"Description", product.getItemDescription() });
    	inventoryTable.addRow(new String[] {"Category", product.getItemCategory()});
    	inventoryTable.addRow(new String[] {"Price", "$" + String.valueOf(product.getItemPrice())});
    	
    	// Change to switch case?
    	switch (product.getItemCategory()) {
    	case "Weapon":
    		inventoryTable.addRow(new String[] {"Rarity",String.valueOf(product.getParm1() )});
    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.getParm2())});
    		inventoryTable.addRow(new String[] {"Damage", String.valueOf(product.getParm3())});
    		break;
    	case "Armor":
    		inventoryTable.addRow(new String[] {"Rarity", String.valueOf(product.getParm1() )});
    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.getParm2())});
    		inventoryTable.addRow(new String[] {"Defense Level", String.valueOf(product.getParm3())});
    		break;
    	case "Health":
    		inventoryTable.addRow(new String[] {"Rate", String.valueOf(product.getParm1())});
    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.getParm2())});
    		inventoryTable.addRow(new String[] {"HP", String.valueOf(product.getParm3())});
    		break;
    		
    	default:
    		System.out.println("Error category is not recognized");
    		break;
    	}
//    	if (product.getItemCategory() == "Weapon") {
//    		inventoryTable.addRow(new String[] {"Rarity", product.getWeapon().getRarity()});
//	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.getWeapon().getType())});
//	    		inventoryTable.addRow(new String[] {"Damage", String.valueOf(product.getWeapon().getDamage())});
//    		
//    	} 
//    	else if (product.getItemCategory() == "Armor") {
//    		inventoryTable.addRow(new String[] {"Rarity", product.GetArmor().getRarity()});
//    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.GetArmor().getType())});
//    		inventoryTable.addRow(new String[] {"Defense Level", String.valueOf(product.GetArmor().getDefenseLevel())});
//    	} else if (product.getItemCategory() == "Health") {
//    		inventoryTable.addRow(new String[] {"Rate", product.getHealth().getRate()});
//    		inventoryTable.addRow(new String[] {"Type", String.valueOf(product.getHealth().getType())});
//    		inventoryTable.addRow(new String[] {"HP", String.valueOf(product.getHealth().getHP())});
//    	}
    
    //table.addRow(new String[] {"Lebron", "James", "LAL"});
    
    
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

