package milestone;
import java.util.ArrayList;


public class ShoppingCart extends StoreSTORE {
	private double totalCost;
	private int totalQuantity;
	private boolean isEmpty;
	private ArrayList<Product> shoppingCart;
	private Product cartCopy;

	
public ShoppingCart() {
	clearCart();
	//Default Constructor
	//Avoid placing code here
}



//Return the total cost, currently not used

public double getTotalCost(ShoppingCart cart) {
	totalCost = 0.0;
	
	for (int i = 0; i < cart.getShoppingCart().size(); i++) {
		
		totalCost = totalCost + (cart.getShoppingCart().get(i).getItemPrice() * cart.getShoppingCart().get(i).getItemQuantity());
	}
	
	return totalCost;
}

// THIS IS JUST USED TO TELL IF CART IS EMPTY, does not refer to the actual items, needs a for loop 
// Not currently in use
public int getTotalQuantity() {
	totalQuantity = this.shoppingCart.size();
	return totalQuantity;
}



//Cart things
public void addToCart(Product product, int amtToCart) {
	
	boolean itemMatched = false;
	for (int i = 0; i < shoppingCart.size(); i++) {
		if (product.getItemID() == shoppingCart.get(i).getItemID()) {
			itemMatched = true;
			
			int newAmt = shoppingCart.get(i).getItemQuantity();

			setEmpty(false);
			shoppingCart.get(i).setItemQuantity(amtToCart + newAmt);

		} else {
			//System.out.println("Error at shoppingCart addto Cart, after matching in for loop");
		}
	}
	
	
	if (!itemMatched) {
		
		
		
		
		//System.out.println("Not already in Cart");
		//product.setItemQuantity(amtToCart);
		
		cartCopy = new Product(product);
		
		cartCopy.setItemQuantity(amtToCart);
		
		
		shoppingCart.add(cartCopy);

		setEmpty(false);
	}
	
}
// Remove item from shopping cart 


public void removeFromCart(int itemPos, int amt) {
	
	
	int oldCartAmt = this.shoppingCart.get(itemPos).getItemQuantity();
	
	
	if (amt == 0) {
		
		// TODO this needs to go back into Inventory
	this.shoppingCart.remove(itemPos);
	
	
	
	} else if (amt > 0) {
		if (oldCartAmt < amt) {
			System.out.println("Error: DO NOT ADD ITEMS HERE, use store front.");
		} else {
		Product newItem = this.shoppingCart.get(itemPos);
		newItem.setItemQuantity(amt);
		this.shoppingCart.set(itemPos, newItem);
		}
		
	} else {
		System.out.println("NEGATIVE NUMBER DETECTED");
	}
	
	
	
	// Remove empty items from cart
	
	for (int i = 0; i < this.shoppingCart.size(); i ++) {
		
		if (this.shoppingCart.get(i).getItemQuantity() == 0) {
			this.shoppingCart.remove(i);
		}
	}
	
	
	
	
	
	
}

// Return the shoppingCart ArrayList
public ArrayList<Product> getShoppingCart() {
	return shoppingCart;
}


public void setShoppingCart(ArrayList<Product> shoppingCart) {
	this.shoppingCart = shoppingCart;
}
// Clear the shoppingCart

public void clearCart() {
	//Blank shopping cart, run at start and end of checkout
	ArrayList<Product> blankShoppingCart = new ArrayList<Product>();
	this.shoppingCart = blankShoppingCart;
	setEmpty(true);
}

//Used to display the shoppingCart option to the user in MainDriver
public boolean isEmpty() {
	this.isEmpty = true;
	
	if (this.shoppingCart.size() > 0) {
		
		setEmpty(false);
	}
	return this.isEmpty;
}

// sets the empty to true or false, used for the cart display option
private void setEmpty(boolean isEmpty) {
	this.isEmpty = isEmpty;
}
}
