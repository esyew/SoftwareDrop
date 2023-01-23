package mileStone1;
import java.util.ArrayList;


public class ShoppingCart {
	private double totalCost;
	private int totalQuantiy;
	private ArrayList<Product> shoppingCart;
	
public ShoppingCart() {
	//Default Constructor
	//Avoid placing code here
}



public double getTotalCost() {
	return totalCost;
}

public void setTotalCost(double totalCost) {
	
	this.totalCost = totalCost;
}

public int getTotalQuantiy() {
	totalQuantiy = this.shoppingCart.size();
	return totalQuantiy;
}



//Cart things
public void addToCart(Product product) {
	this.shoppingCart.add(product);
	
}
public void removeFromCart(int itemPos, int amt) {
	
	if (amt == 0) {
	this.shoppingCart.remove(itemPos);
	} else if (amt > 0) {
		if (this.shoppingCart.get(itemPos).getItemQuantity() < amt) {
			System.out.println("Error: DO NOT ADD ITEMS HERE, use store front.");
		} 
		Product newItem = this.shoppingCart.get(itemPos);
		newItem.setItemQuantity(amt);
		this.shoppingCart.set(itemPos, newItem);
		
	} else {
		System.out.println("NEGATIVE NUMBER DETECTED");
	}
	
}


public ArrayList<Product> getShoppingCart() {
	return shoppingCart;
}

public void setShoppingCart() {
	//Blank shopping cart, run at start and end of checkout
	ArrayList<Product> blankShoppingCart = new ArrayList<Product>();
	this.shoppingCart = blankShoppingCart;
	
}



}
