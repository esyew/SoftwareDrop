package milestone;

// The purpose of this is to allow both the inventory 
// and the cart to be stored between inventory display and checkout processes.
// Used with the main method, will likely remove this. 
public class StoreSTORE {
ShoppingCart cart;
Inventory inventory;

/**
 * @return the cart
 */
public final ShoppingCart getCart() {
	return cart;
}

/**
 * @param cart the cart to set
 */
public final void setCart(ShoppingCart cart) {
	this.cart = cart;
}

/**
 * @return the inventory
 */
public final Inventory getInventory() {
	return inventory;
}

/**
 * @param inventory the inventory to set
 */
public final void setInventory(Inventory inventory) {
	this.inventory = inventory;
}



StoreSTORE() {
	
}

}
