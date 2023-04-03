package milestone;
import java.util.ArrayList;
import java.util.List;

import milestone.Types.Armor;
import milestone.Types.Health;
import milestone.Types.Weapon;

// ArrayList<Class<? extends Product>>


// TrackContainer<T> extends ArrayList<Track<T>>

// Did my best to make this use generics, but I really don't know how else this should be done (Milestone 5)

// Modeled after Activity 5
public class ShoppingCart<T extends Product> extends ArrayList<Product> {



	private double totalCost;
	private int totalQuantity;
	private boolean isEmpty;


// https://stackoverflow.com/questions/749425/how-do-i-use-generics-with-an-array-of-classes#749456
	//private ArrayList<T> shoppingCart; // Not super sure if this works for M5, since it is basically the same thing as before.

	private List<T> shoppingCart = new ArrayList<T>();



	public ShoppingCart() {

	//Default Constructor
	clearCart();

	//Avoid placing code here
}

// TODO Empty cart completely, without purchasing anything.



//Return the total cost, currently not used
/**
 *
 * @return double of the total cart cost
 */
public double getTotalCost() {
	totalCost = 0.0;

	for (int i = 0; i < shoppingCart.size(); i++) {

		totalCost += (shoppingCart.get(i).getItemQuantity() * shoppingCart.get(i).getItemPrice());
	}

	return totalCost;
}

// THIS IS JUST USED TO TELL IF CART IS EMPTY, does not refer to the actual items, needs a for loop
// Not currently in use
/**
 * Return number of item types in the the cart
 * NOT USED TO SHOW FULL AMT
 * Just the unique items in cart
 * @return int of number of types of items in cart, not affected by the quantity variable.
 */
public int getTotalQuantity() {
	totalQuantity = shoppingCart.size();
	return totalQuantity;
}



//Cart things
/**
 *
 * @param product the item to be added
 * @param amtToCart the amount of items to be added
 */
public void addToCart(Product product, int amtToCart) {


	boolean itemMatched = false;

	for (int i = 0; i < shoppingCart.size(); i++) {

		if (shoppingCart.get(i).getItemID() == product.getItemID()) {
			itemMatched = true;


			int newAmt = shoppingCart.get(i).getItemQuantity() + amtToCart;

			setEmpty(false);
			shoppingCart.get(i).setItemQuantity(amtToCart + newAmt);

		} else {
			//System.out.println("Error at shoppingCart addto Cart, after matching in for loop");
		}
	}


	if (!itemMatched) {




		//System.out.println("Not already in Cart");
		//product.setItemQuantity(amtToCart);


		String cat = product.getItemCategory();

		if (cat.equals("Weapon")) {

			Weapon weaponCopy = new Weapon(product.getItemID(),
					 product.getItemQuantity(),
					 product.getItemName(),
					 product.getItemCategory(),
					 product.getItemDescription(),
					 product.getItemPrice(),
					 product.getStripeID(),
					 product.getParm1(), product.getParm2(), product.getParm3());

			weaponCopy.setItemQuantity(amtToCart);
			shoppingCart.add((T) weaponCopy);
		} else if (cat.equals("Armor")) {


			Armor armorCopy = new Armor(product.getItemID(),
					 product.getItemQuantity(),
					 product.getItemName(),
					 product.getItemCategory(),
					 product.getItemDescription(),
					 product.getItemPrice(),product.getStripeID(), product.getParm1(), product.getParm2(), product.getParm3());

			armorCopy.setItemQuantity(amtToCart);
			shoppingCart.add((T) armorCopy);

		} else if (cat.equals("Health")) {
			Health healthCopy = new Health(product.getItemID(),
				 product.getItemQuantity(),
				 product.getItemName(),
				 product.getItemCategory(),
				 product.getItemDescription(),
				 product.getStripeID(), product.getItemPrice(), product.getParm1(), product.getParm2(), product.getParm3());

				healthCopy.setItemQuantity(amtToCart);
			shoppingCart.add((T) healthCopy);

		}

		setEmpty(false);
	}

}
// Remove item from shopping cart

/**
 *
 * @param itemPos Position of the item
 * @param amt number of items to keep in the cart
 */
public void removeFromCart(int itemPos, int amt) {


	int oldCartAmt = this.shoppingCart.get(itemPos).getItemQuantity();


	if (amt == 0) {


	this.shoppingCart.remove(itemPos);




	} else if (amt > 0) {
		if (oldCartAmt < amt) {
			System.out.println("Error: DO NOT ADD ITEMS HERE, use store front.");
		} else {
		Product newItem = this.shoppingCart.get(itemPos);
		newItem.setItemQuantity(amt);
		this.shoppingCart.set(itemPos, (T) newItem); // Needs to copy
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
/**
 * getter for the cart
 *
 * @return full shoppingcart
 */
//public List<T> getShoppingCart() {
//
//	return shoppingCart;
//}

public Product getItem(int pos) {
	return shoppingCart.get(pos);
}


//public void setShoppingCart(ArrayList<Product> shoppingCart) {
//	this.shoppingCart = shoppingCart;
//}
// Clear the shoppingCart
/**
 * empty the cart of all items
 */
public void clearCart() {
	//Blank shopping cart, run at start and end of checkout

	for (int i = getTotalQuantity(); i > 0; i--) {
		shoppingCart.remove(i-1);
	}

	setEmpty(true);
}

//Used to display the shoppingCart option to the user in MainDriver
public boolean isEmpty() {
	this.isEmpty = true;

	if (getTotalQuantity() > 0) {

		setEmpty(false);
	}
	return this.isEmpty;
}

// sets the empty to true or false, used for the cart display option
private void setEmpty(boolean isEmpty) {
	this.isEmpty = isEmpty;
}


}
