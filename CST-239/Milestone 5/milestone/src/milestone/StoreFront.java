package milestone;

import java.text.DecimalFormat;
import java.util.List;

public class StoreFront {
	
	
	// This class is used mostly to handle the cart, and does not store data.

	/**
	 * Displays the cart in a readable format
	 * @param shoppingCart ShoppingCart to display to the user
	 */
public static void getCartInfo(ShoppingCart shoppingCart) {
	System.out.println("\nSHOPPING CART");
	//Using https://github.com/kandicst/Java-Console-Table
	//StoreFront.clearWindow();
		String[] headers = {"Index","Product Name", "Item Price", "Num in Cart"};
	    TableDisplay inventoryTable = new TableDisplay(headers);
	    
	    
	    
	    
	    for (int i = 0; i < shoppingCart.getTotalQuantity(); i++) {
	    	
	    	
	    	// TODO Temp, hide canceled purchases from the ShoppingCart, hopefully will be fixed. But works for now.
	    	// This could be giving hiding factor of a negative sum, as it makes that harder to diagonose.
	    	
	    	if (shoppingCart.getItem(i).getItemQuantity() > 0) {
	    		inventoryTable.addRow(new String[] {String.valueOf(i + 1), shoppingCart.getItem(i).getItemName(), "$" + String.valueOf(shoppingCart.getItem(i).getItemPrice()), String.valueOf(shoppingCart.getItem(i).getItemQuantity())});

	    	} 
	    	
	    		    	
	    }



	    final DecimalFormat df = new DecimalFormat("#.##");
	   
	    
	    
	    inventoryTable.addRow(new String[] {"","","Sum: $"+ String.valueOf(df.format(shoppingCart.getTotalCost())),""});
	    
	    // Display inventory to the user
	    inventoryTable.show();
	}
/**
 * 
 * @param product Product to display the details to the user
 */
public static void DisplayItem(Product product) {
	
	
	String[] headers = {"    ", product.getItemName()};
    TableDisplay inventoryTable = new TableDisplay(headers);
    
    
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

    
    
    inventoryTable.show();
	
	
	
	
	
}

/**
 * Displays a inventory list to the user 
 * @param inventory inventory to show the user
 */
public static void DisplayInventory(Inventory inventory) {
	//Using https://github.com/kandicst/Java-Console-Table
	
	String[] headers = {"Index","Product Name", "Price", "Category", "Num in Stock"};
    TableDisplay inventoryTable = new TableDisplay(headers);
    
    
    for (int i = 0; i < inventory.inventoryUnqCnt(); i++) {

    	inventoryTable.addRow(new String[] {String.valueOf(i + 1), inventory.getItem(i).getItemName(), "$" + String.valueOf(inventory.getItem(i).getItemPrice()), inventory.getItem(i).getItemCategory(), String.valueOf(inventory.getItem(i).getItemQuantity())});
    }

    
    
    inventoryTable.show();
		
	}

	

	

}

