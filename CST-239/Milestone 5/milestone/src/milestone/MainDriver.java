package milestone;


import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import milestone.functions.ProductPriceComparator;


public class MainDriver {

	// Set this boolean to disable extra features like Stripe Payments, or firebase, disable for grading
	public static final boolean advanced = false; // CHANGE THIS FOR GRADING ISSUES
	public static boolean ended = false;

	//static FillStore inventory;
	private static Inventory inventory;

	
	
	// Ask user for a keypress depending on what is needed

	@SuppressWarnings("resource")
	public static int getUserInput(int minInt, int maxInt) {
// Function with error handling that accepts a min and a max integer. 



			// Would use a try and catch, however there hav been some runtime issues with it. 
			Scanner input = new Scanner(System.in);
				int userSelect;
				
				// Wait for user to input 
				if(input.hasNextInt() ) {
					userSelect = input.nextInt(); 



					 if (userSelect > maxInt) { // Ensure not above allowable limits
					    	System.out.println("ERROR: the number you typed was greater than " + maxInt);
					    } else if (userSelect < minInt) { // Ensure not below allowed limits
					    	System.out.println("ERROR: the number you typed was less than " + minInt);
					    } else { // Good user input
					    	// Good userInput
				//	    	System.out.println("");
					    	return userSelect;
					    }
					// Restart user Collection if failed
					System.out.println("Please type a number between " + minInt + " and " + maxInt + ": ");
					//System.out.println("");
					return getUserInput(minInt, maxInt);
					
				}
	 				// THIS SHOULD NEVER HAPPEN, but throws an error that can optionally be processed
				else {

					//userSelect = -23753; // nothing added in the input
					System.out.println("Make sure you entered a integer input.\n(MD.getuserInput)");
					return getUserInput(minInt, maxInt);
				}

			
		}
		

	
// Used to clear the console window
	public static void clearWindow() {
		for(int i = 0; i < 10; i++)
		{
			
			// This hides previous code
		    System.out.println("\n\n");
		}
		
	}
	
// Killing firebase :<







// If there are issues with Stripe, set advanced to false at start of MainDriver
	// Mostly copied code from the Stripe API Docs


    public static String generatePayLink(ShoppingCart cart) throws StripeException {

    	Stripe.apiKey = "sk_test_51MSFGlBQ8Ird4Uj5MHe0nwrK5Midf8YkhpQ9H84TgkvKCAYCbkvL36i739hKgDrnLGMPICTVgP2rTexXdjbXYN7K00hCpeXE5y";



		// Maybe delete all existing products in Stripe?

		// Create products for all items in ShoppingCart, as well as using default price data


		// Create payment link
    	List<Object> lineItems = new ArrayList<>();


    	int cartNums = cart.getTotalQuantity();

    	for (int i = 0; i < cartNums; i++)
    	{
    		Map<String, Object> lineItem = new HashMap<>();
    		lineItem.put(
    		  "price", cart.getItem(i).getStripeID());
    	//	 cart.getShoppingCart().ge

    		lineItem.put("quantity", cart.getItem(i).getItemQuantity());
    		lineItems.add(lineItem);
    	}




    	Map<String, Object> params = new HashMap<>();
    	params.put("line_items", lineItems);
    	params.put("automatic_tax[enabled]", true);
    	PaymentLink paymentLink =
    	  PaymentLink.create(params);

    	return paymentLink.getUrl();
    }





	public static void updateShortLink(String stripeLink) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.short.io/links/lnk_1xG7_9dCPkow92P9"))
				.header("accept", "application/json")
				.header("content-type", "application/json")
				.header("Authorization", "sk_xIEkq1g0QnNHCfif")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\"originalURL\":\"" + stripeLink + "\"}"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


	}
    
	// This could also be done in the while loop, but was having issues doing that before.
	private static StoreSTORE storeFlow(StoreSTORE data) throws IOException, InterruptedException {
		
		// ShoppingCart
		// ShoppingCart shoppingCart, Inventory inventory
		ShoppingCart shoppingCart = data.cart;
		Inventory inventory = data.inventory;
		//inventory.loadJsonInventory();
		
		

		// Milestone 5
		// Give options for user to type
		System.out.println("\n\033[0;1mOPTIONS");
		if (!data.cart.isEmpty()) {
			System.out.println("\nType 0 to go to your Shopping Cart");
		}
		System.out.println("Type -1 for sort options");
		System.out.println("Type -2 to exit the store (end program)");
		
		// Checks if cart has items, if so tells user they can 

		
		System.out.println("\nCURRENT INVENTORY");
		
		
		StoreFront.DisplayInventory(inventory);
		System.out.print("Enter the Index number for a item to view its details: ");
		
		
		//Scanner myObj = new Scanner(System.in);
		//int TESTSELECT = getUserInput(0,69);
		int userSelection = getUserInput(-2, inventory.inventoryUnqCnt());
		
		boolean goodCollect = false;
		if ((userSelection == 23753)|(userSelection == -2)) {
			System.out.println("GOOD BYE!");
			ended = true;
			System.exit(0);
		} else {
			goodCollect = true;
		}



		if ((userSelection == -1) && goodCollect) {
			System.out.println("\nSORT OPTIONS");
			System.out.println("0. Cancel");

			System.out.println("1. Price Ascending");
			System.out.println("2. Price Descending");

			System.out.println("3. Name Ascending");
			System.out.println("4. Name Descending");

			System.out.print("\nType an int (0-4): ");


			inventory.sort(getUserInput(0,4));


		}
		
		
		
		// ShoppingCart
	if ((userSelection == 0) && goodCollect) {
			
		//GO TO SHOPPING CART
			StoreFront.getCartInfo(shoppingCart); // Display cart
			System.out.print("Type 0 to Continue Shopping\n Type 1 to change item quantity or remove item\n Type 2 to check out.");
			int userSelectionItem = getUserInput(0, 2); // Get user choice
			//ShoppingCart Options
			
			
			// Initial Choice 
			switch(userSelectionItem) {
			  case 0:
			    // Continue Shopping
			    break;
			  case 1:
			 // Change item quantity, cancel items, note this will have to change for the admin application. M6
					if (shoppingCart.getTotalQuantity() <= 0) {
						System.out.println("You can't change something doesn't exist. (MD: UserSelectItem: Case 1");
						break;
					}
				System.out.println("Type 0 to cancel your order completely and return all items in your cart");
				System.out.print("\nType the index of the item you wish to return: ");
				int userSelectionCart = getUserInput(0, shoppingCart.getTotalQuantity());
				
				if (userSelectionCart == 0) {
					// Clear cart after adding back all items (cancel order)
					inventory.cancelCart(shoppingCart);
					shoppingCart.clearCart();
				} else {
				
					// Change items in cart 
				//int cartSelectOGAmt = shoppingCart.getShoppingCart().get(userSelectionCart - 1).getItemQuantity();
					int cartSelectOGAmt = shoppingCart.getItem(userSelectionCart - 1).getItemQuantity();
				
				
				System.out.print("\nEnter the number of items to keep, type 0 to remove all: ");
				
				
				
				Product ogProduct = shoppingCart.getItem(userSelectionCart - 1);
				
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
				}
			  case 2:
				  //Checkout
				 // double totalBeforeTax = shoppingCart.getTotalCost(shoppingCart);
				  
				  double roundedTotalBT = Math.round(shoppingCart.getTotalCost() * 100);
				  roundedTotalBT = roundedTotalBT/ 100.0;
					  System.out.println("Your total before tax: $" + roundedTotalBT);
					  // Arizona Sales Tax
					  // https://www.sale-tax.com/Arizona
					  
					  double afterTax = roundedTotalBT * 1.086;
					  afterTax = Math.round(afterTax * 100.00);
					  afterTax = afterTax/ 100.00;
					  System.out.println("Your total after tax: $" + afterTax);
					  
					  
					  // Payment Processing
					 


				  if (!advanced) {
					  // No Stripe
					  if (!shoppingCart.isEmpty()) {



							  System.out.print("\nContinue with Purchase? (type 1) (different int for no): ");


							  if (getUserInput(-999999999, 999999999) == 1) {


								  // Clear shoppingCart
								  shoppingCart.clearCart();
								  System.out.println("Order Success!\n Press any key then enter to start new order.");
								  try {
									  System.in.read();
								  } catch (Exception e) {
									  System.out.println("Error checking out confirm.");
								  }

							  } else {
								  // Should not get here, however could still happen.
							  }
						  break;


					  }

				  } else {

				if (!shoppingCart.isEmpty()) {
					try {
						// Generate a payment link
						String checkoutURL = generatePayLink(shoppingCart);
						 updateShortLink(checkoutURL);
						//System.out.println("Stripe URL: " + checkoutURL);
						// Update the short link to the checkoutURL, Note this API Key is private, please keep it (and this code) relatively safe.

						//System.out.println(response.body());
						System.out.println("You can pay at Stripe, no money will be transacted");
						// QR code for link

							System.out.println("SCAN ME FOR LINK\n"
									+ "█▀▀▀▀▀█ ▀▀▀ ▄ █   █▀▀▀▀▀█\n"
									+ "█ ███ █  █  ▀██▄▄ █ ███ █\n"
									+ "█ ▀▀▀ █   ██ ██ ▀ █ ▀▀▀ █\n"
									+ "▀▀▀▀▀▀▀ █ █ ▀▄▀ ▀ ▀▀▀▀▀▀▀\n"
									+ "▀▀▄█▀ ▀▄▄██▄▀▄█▄▀▄▀▄▄▄▄▄▀\n"
									+ "█ ▀▄ █▀█▀▄█▀▀ ▄▀ █▀█▀█▄▄█\n"
									+ "▄ ██▄▄▀▄█▀ ▄▀ ▄▄█ ▀▀▄  ▄▀\n"
									+ "█▀█▄█▄▀███ ▄ ▀ █▀▄▄▄▀██▀█\n"
									+ "▀ ▀▀ ▀▀ ▄▀█ ▀█  █▀▀▀█ ██ \n"
									+ "█▀▀▀▀▀█  █▄▀▀█▄ █ ▀ █  ▄▀\n"
									+ "█ ███ █ █▀█▄  ██▀██▀▀  █▄\n"
									+ "█ ▀▀▀ █ ▄▀▀▀▄ ▄▀▀█▄▄█▀███\n"
									+ "▀▀▀▀▀▀▀ ▀ ▀▀    ▀    ▀  ▀");

						System.out.println("Scan the above code or go to : " + checkoutURL);

						System.out.print("\nContinue with Purchase? (type 1) (different int for no): ");


						if (getUserInput(-999999999, 999999999) == 1) {

							try {
								Desktop.getDesktop().browse(new URL(checkoutURL).toURI());
							} catch (Exception e) {
							}
							// Clear shoppingCart
							shoppingCart.clearCart();
							System.out.println("Order Success!\n Press any key then enter to start new order.");
							try {
								System.in.read();
							} catch (Exception e) {
								System.out.println("Error checking out confirm.");
							}

							break;

						} else {
							// User cancels purchase, go back to inventory
							break;
						}

					} catch (StripeException e1) {

						e1.printStackTrace();
					}
				}
				}
				

			  default:
			    break;
			}
			
			
		// Inventory
		} else if ((userSelection > 0) && (userSelection <= (inventory.inventoryUnqCnt())))
		{

			
			
			
			
		//GO TO ITEM DETAILS
		//Display item Details
		clearWindow();
		
		
		//Product currentProduct = inventory.get(userSelection - 1);
			int currentPos = userSelection - 1;
		Product currentProduct = inventory.getItem(currentPos);

		//currentProduct.displayProduct();
		StoreFront.DisplayItem(currentProduct);
		
		
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
		
		clearWindow();
		} else if ((userSelection == -1) && goodCollect) {
			// Sort Options
			
			System.out.println("\n\n\n\nSORT OPTIONS");
			
		} else if (!goodCollect) {
			System.out.println("Failed init data collection for idx inventory");
		} else {
			System.out.print("How you get here? (MD-failed data collect on inventory) line number: ");
		//	https://stackoverflow.com/questions/17473148/dynamically-get-the-current-line-number#17473358
			System.err.print(new Throwable().getStackTrace()[0].getLineNumber());

			System.out.println("\nMake sure your selection is not more than the last index amt or less than -1");
			
		}

		// Returns the Inventory and Cart to the while loop in main. 
		StoreSTORE returnData = new StoreSTORE();
//		returnData.setCart(shoppingCart);
//		returnData.setInventory(inventory);
		returnData.cart = shoppingCart;
		returnData.inventory = inventory;
		
		
		
		return returnData;
	} 
	
	

	
	public static void main(String[] args) throws IOException, InterruptedException {





		// Create default inventory // Removed in Milestone 4
		
		
		
		//ArrayList<Product> defaultStore = new FillStore().getDefaultInventory();
		
		
			// Downloads a updated version of the database from the web
			// If this fails, a saved version should be in project. 
			// Eventually, this be hopefully be a two way street, but that is not the case right now.
		//downloadJSON(); // Download from Firebase DB, replaces the current json in project, TODO add handling for failed download
		// inventory = new inventoryJson();
		
		inventory = new Inventory(); // Initalize the inventory

		//Fill the inventory with items from JSON
	//	inventory.resetInventory();
		inventory.inventoryJson(); // Prep from JSOn
		//inventory.jsonInventoryFill(); // Old code
		
		// Create a shoppingCart
		ShoppingCart shoppingCart = new ShoppingCart(); // Blank ShoppingCart with default constructor

		// Create a StoreSTORE, wrapper for the storeFlow to handle easier
		StoreSTORE data = new StoreSTORE();
			
		


		// Welcome User with message
		// Stripe payments: https://stripe.com/docs/testing?testing-method=card-numbers
		System.out.println("Hello, welcome to legitRus!");
		System.out.println("We tried to be EA Sports, but they tried to sue us");
		System.out.println("   For legal reasons, nothing here is actually for sale." + "\033[3m You can still pay however!\033[0m");
//		System.out.println("");



		
		int sortOption = 0; // Used to save how the user wants to sort the view (Milestone 5)

		//START MAIN INTERFACE
		// Maybe stop the while loop once the inventory is out of stock?

		while (!ended) {
//			data.setInventory(inventory);
//			data.setCart(shoppingCart);
			data.inventory = inventory;
			data.cart = shoppingCart;
			
			data = storeFlow(data);

			
			data.inventory = inventory;
			data.cart = shoppingCart;
		
			//System.out.println("Restarting order process, cart has been cleared");
		
			

		}
		
	

	}





}
