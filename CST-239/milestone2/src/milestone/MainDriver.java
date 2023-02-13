package milestone;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class MainDriver {
	//static FillStore inventory;
	private static ArrayList<Product> inventory;

	


	public static void clearWindow() {
		for(int i = 0; i < 10; i++)
		{
		    System.out.println("\n");
		}
	}
	
	
	
	public static void main(String[] args) {
		// Create default inventory
		
		
		
		ArrayList<Product> defaultStore = new FillStore().getDefaultInventory();
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setShoppingCart();
		
		//Fill the inventory with basic items
		inventory = defaultStore;
		//shoppingCart = 
		
		System.out.println("Hello, welcome to legitRus!");
		System.out.println("We tried to be EA Sports, but they tried to sue us");
	//	System.out.println("   For legal reasons, nothing here is actually for sale.\n   You can still pay however!");


		
		//START MAIN INTERFACE
		
		while (3 != 4) {
			//clearWindow();
			//INFINITE LOOP!!
			if (shoppingCart.getTotalQuantiy() > 0) {
				System.out.println("\nType 0 to go to your Shopping Cart");
			}
			
			System.out.println("\nCURRENT INVENTORY");
			StoreFront.DisplayInventory(inventory);
			System.out.print("Enter the Index number for a item to view its details: ");
			Scanner myObj = new Scanner(System.in);
			int userSelection = myObj.nextInt();
			if (userSelection == 0) {
			//GO TO SHOPPING CART
				StoreFront.getCartInfo(shoppingCart.getShoppingCart());
				System.out.println("Type 0 to Continue Shopping\n Type 1 to change item quantity or remove item\n Type 2 to check out.");
				userSelection = myObj.nextInt();
				//ShoppingCart Options
				//Use switch case
				
				switch(userSelection) {
				  case 0:
				    // Continue Shopping
				    break;
				  case 1:
				    // Change or Remove item
					  
					System.out.print("\nType the index of the item to change: ");
					userSelection = (myObj.nextInt() - 1);
					System.out.print("\nEnter the number of items to keep, 0 to remove all: ");
					int userAmtToRm = myObj.nextInt();
					
					shoppingCart.removeFromCart(userSelection, userAmtToRm);
					//shoppingCart.
				    break;
				  case 2:
					  //Checkout
					  double totalBeforeTax = StoreFront.sumTotal(shoppingCart.getShoppingCart());
					  if (StoreFront.Checkout(totalBeforeTax)) {
						  //Clear ShoppingCart
						  shoppingCart = new ShoppingCart();
						  shoppingCart.setShoppingCart();
					  }else {
						  break;
					  }
					  
				  default:
				    // code block
				}
				
				
			
			} else if (userSelection > 0){
			//GO TO ITEM DETAILS
			//Display item Details
			//StoreFront.clearWindow();
			
			
			Product currentProduct = inventory.get(userSelection - 1);
			int currentPos = userSelection - 1;
			currentProduct.displayProduct();
			//Ask user for decision on item
			System.out.println("0: Add to Cart\n1: Return to store");
			System.out.print("\nType a number for your decision: ");
			userSelection = myObj.nextInt();
			//User adds item to Cart or rejects it
			if ((userSelection == 1) || (userSelection == 0)) {
				if (userSelection == 1) {
					
				} else {
					//Update inventory with one fewer item
					int oldStock = currentProduct.getItemQuantity();
					int userQuanity = 1;
					System.out.print("How many would you like to purchase?\n0: Cancel Purchase\nQuantity to purchase: ");
					userQuanity = myObj.nextInt();
					
					if (userQuanity > oldStock) {
						System.out.println("OUT OF STOCK, limit your purchase to " + oldStock +" items.");
						
					} else if (userQuanity <= oldStock) {
					
					
					
					//currentProduct.setItemQuantity(oldStock - userQuanity);
					inventory.get(currentPos).setItemQuantity(oldStock - userQuanity);
					//Add item to ShoppingCart
					var shoppingCartProduct = inventory.get(currentPos);
					shoppingCart.addToCart(shoppingCartProduct);
				//	shoppingCartProduct.setItemQuantity(userQuanity);
					//ShoppingCart.add(shoppingCartProduct)
					//ShoppingCart
					} else {
						System.out.println("Error: ensure you are not purchasing less than 1 item.");
					}
				}
			}
			
			//clearWindow();
			}
		//	clearWindow();
			for(int i = 0; i < 5; i++)
			{
			   // System.out.println("\n");
			}
			
		}
		
		
		
	
		
	}





}
