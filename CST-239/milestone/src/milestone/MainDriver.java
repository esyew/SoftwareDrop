package milestone;


import java.util.Scanner;

public class MainDriver {
	//static FillStore inventory;
	private static Inventory inventory;

	
	
	// Ask user for a keypress depending on what is needed

	public static int getUserInput(int minInt, int maxInt) {

		@SuppressWarnings("resource")
		// Would use a try and catch, however there hav been some runtime issues with it. 
		var input = new Scanner(System.in);
			int userSelect;
			if(input.hasNextInt() ) {
				userSelect = input.nextInt(); 
				//input.close();
				
				 if (userSelect > maxInt) {
				    	System.out.println("ERROR: the number you typed was greater than " + maxInt);
				    } else if (userSelect < minInt) {
				    	System.out.println("ERROR: the number you typed was less than " + minInt);
				    } else {
				    	// Good userInput
			//	    	System.out.println("");
				    	return userSelect;
				    }
				// Restart user Collection if failed
				System.out.println("Please type a number between " + minInt + " and " + maxInt + ": ");
				//System.out.println("");
				return getUserInput(minInt, maxInt);
				
			}
 
			else {
				//input.close();
				userSelect = -2000; // nothing added in the input 
			//	System.out.println("");
				return userSelect;
			}
		}


		
	
	

	public static void clearWindow() {
		for(int i = 0; i < 10; i++)
		{
		    System.out.println("\n");
		}
	}
	
	
	
	
	private static StoreSTORE storeFlow(StoreSTORE data) {
		// ShoppingCart shoppingCart, Inventory inventory
		ShoppingCart shoppingCart = data.getCart();
		Inventory inventory = data.getInventory();
		
		
		//clearWindow();
		
		
		if (!data.getCart().isEmpty()) {
			System.out.println("\nType 0 to go to your Shopping Cart");
		}
		
		System.out.println("\nCURRENT INVENTORY");
		
		
		StoreFront.DisplayInventory(inventory.getInventory());
		System.out.print("Enter the Index number for a item to view its details: ");
		
		
		//Scanner myObj = new Scanner(System.in);
		//int TESTSELECT = getUserInput(0,69);
		int userSelection = getUserInput(0,inventory.getInventory().size());
		
		boolean goodCollect = false;
		if (userSelection == -200424) {
			System.out.println("ERROR: failed user collect");
			System.exit(0);
		} else {
			goodCollect = true;
		}
		
		
		
		
		if ((userSelection == 0) && goodCollect) {
		//GO TO SHOPPING CART
			StoreFront.getCartInfo(shoppingCart);
			System.out.print("Type 0 to Continue Shopping\n Type 1 to change item quantity or remove item\n Type 2 to check out.");
			int userSelectionItem = getUserInput(0, 2);
			//ShoppingCart Options
			//Use switch case
			
			
			// Initial Choice 
			switch(userSelectionItem) {
			  case 0:
			    // Continue Shopping
			    break;
			  case 1:
			 
					if (shoppingCart.getShoppingCart().size() <= 0) {
						System.out.println("You can't change something doesn't exist. (MD: UserSelectItem: Case 1");
						break;
					}
				System.out.print("\nType the index of the item you wish to return: ");
				int userSelectionCart = getUserInput(1, shoppingCart.getShoppingCart().size());
				
				

				int cartSelectOGAmt = shoppingCart.getShoppingCart().get(userSelectionCart - 1).getItemQuantity();
				
				
				System.out.print("\nEnter the number of items to keep, type 0 to remove all: ");
				
				
				
				Product ogProduct = shoppingCart.getShoppingCart().get(userSelectionCart - 1);
				
				int ogProductSelect = ogProduct.getItemQuantity();
				System.out.println("The og cart amt is " + ogProductSelect);
				
				int userAmtToKeep = getUserInput(0, ogProductSelect);
				int cartAddBack = cartSelectOGAmt - userAmtToKeep;
				
				// System.out.println("Add back " + cartAddBack + " items into inventory");
				
				
				
				shoppingCart.removeFromCart(userSelection, userAmtToKeep);
				
				//shoppingCart. = shoppingCart.getShoppingCart();

				
				// Add back into inventory
				inventory.addBackInventory(ogProduct, cartAddBack);
				
			    break;
			  case 2:
				  //Checkout
				 // double totalBeforeTax = shoppingCart.getTotalCost(shoppingCart);
				  
				  double roundedTotalBT = Math.round(shoppingCart.getTotalCost(shoppingCart) * 100);
				  roundedTotalBT = roundedTotalBT/ 100.0;
					  System.out.println("Your total before tax: $" + roundedTotalBT);
					  // Arizona Sales Tax
					  // https://www.sale-tax.com/Arizona
					  
					  double afterTax = roundedTotalBT * 1.086;
					  afterTax = Math.round(afterTax * 100.00);
					  afterTax = afterTax/ 100.00;
					  System.out.println("Your total after tax: $" + afterTax);
					
					System.out.print("\nContinue with Purchase? (type 1) (other int for no): ");
				  
				  
					
					
					if (getUserInput(-999999999, 999999999) == 1) {
						// Clear shoppingCart
						shoppingCart.clearCart();
						System.out.println("Order Success!\n Press any key then enter to start new order.");
						try
				        {
				            System.in.read();
				        }  
				        catch(Exception e)
				        {
				        	System.out.println("Error checking out confirm.");
				        }  

						break;
						
					} else {
						// Should not get here, however could still happen.
						break;
					}
					
		
				  
			  default:
			    break;
			}
			
			
		
		} else if ((userSelection > 0) && (userSelection <= (inventory.getInventory().size())))
		{

			
			
			
			
		//GO TO ITEM DETAILS
		//Display item Details
		//StoreFront.clearWindow();
		
		
		//Product currentProduct = inventory.get(userSelection - 1);
			int currentPos = userSelection - 1;
		Product currentProduct = inventory.getInventory().get(currentPos);

		currentProduct.displayProduct();
		//Ask user for decision on item
		System.out.println("0: Add to Cart\n1: Return to store");
		System.out.print("\nType a number for your decision: ");
		
		int userSelectionProduct = getUserInput(0,1);
		
		//User adds item to Cart or rejects it
		if ((userSelectionProduct == 1) || (userSelectionProduct == 0)) {
			if (userSelectionProduct == 1) {
				
			} else {
				
				//Update inventory with one fewer item
				int oldStock = currentProduct.getItemQuantity();
				int userQuanity = 1;
				System.out.print("How many would you like to purchase?\n0: Cancel Purchase\nQuantity to purchase: ");

				userQuanity = getUserInput(0, oldStock);
				
				
				if (userQuanity > oldStock) {
					System.out.println("OUT OF STOCK, limit your purchase to " + oldStock +" items.");
					
				} else if (userQuanity <= oldStock) {
				
				// remove from inventory & add to cart.
				inventory.modifyInventoryCnt(currentProduct, userQuanity);
				shoppingCart.addToCart(currentProduct, userQuanity);
				
				

			//	shoppingCartProduct.setItemQuantity(userQuanity);
				//ShoppingCart.add(shoppingCartProduct)
				//ShoppingCart
				} else if (userQuanity == 0) {
					// Go to inventory
					// This is given when the user declines to add a item to the cart
					
				}
				else {
					// This is given if the user trys to purchase negative items. This is not how canceling a purchase works.
					System.out.println("Error: ensure you are not purchasing less than 1 item.");
				}
			}
		}
		
		//clearWindow();
		} else if (!goodCollect) {
			System.out.println("Failed init data collection for idx inventory");
		} else {
			System.out.println("Make sure your selection is not more or less than the last index amt");
			
		}

		
		
		// Returns the Inventory and Cart to the while loop in main. 
		StoreSTORE returnData = new StoreSTORE();
		returnData.setCart(shoppingCart);
		returnData.setInventory(inventory);
		
		
		
		return returnData;
	}
	
	
	public static void main(String[] args) {
		// Create default inventory
		
		
		
		//ArrayList<Product> defaultStore = new FillStore().getDefaultInventory();
		
		inventory = new Inventory();
		//Fill the inventory with basic items
		inventory.resetInventory();
	
		
		// Create a shoppingCart
		ShoppingCart shoppingCart = new ShoppingCart();

		
		StoreSTORE data = new StoreSTORE();
			
		


		// Welcome User
		System.out.println("Hello, welcome to legitRus!");
		System.out.println("We tried to be EA Sports, but they tried to sue us");
	//	System.out.println("   For legal reasons, nothing here is actually for sale.\n   You can still pay however!");


		
		//START MAIN INTERFACE
		
		while (3 != 4) {
			data.setInventory(inventory);
			data.setCart(shoppingCart);
			
			data = storeFlow(data);
			
			
			
			
			inventory = data.getInventory();
			shoppingCart = data.getCart();
		
			//System.out.println("Restarting order process, cart has been cleared");
		
			
		}

	}





}
