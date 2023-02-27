package milestone;

import java.util.ArrayList;





public class Inventory {
	private ArrayList<Product> inventory;
	
	public Inventory() {
		
	}
	public ArrayList<Product> getInventory() {
		return inventory;
	}
	private void setInventory(final ArrayList<Product> inventorySet) {
		this.inventory = inventorySet;
	}
	
	public void resetInventory() {
		// Runs to create a blank inventory
		inventory = new FillStore().getDefaultInventory();
		
	}
	
	// Positive amt for adding, negative for removing
	public void modifyInventoryCnt(Product product, int amt) {
		int oldStock = product.getItemQuantity();
		
		//System.out.println("og amt: " + oldStock);
		if (oldStock < amt) {
			
			System.out.println("Error: you shouldn't have gotten here, this is a final check\n"
					+ "This is in Inventory.modifyInventoryCart, it is generated from the inventory quantity being less than amt taken");
		} else {
			
			
			for (int i = 0; i < getInventory().size(); i++) {
				//System.out.println("hey");
				
				
				if (getInventory().get(i).getItemID() == product.getItemID()) {
					
					
					
				//	System.out.println("The array location for the product is : " + i);
					
					
					// Modify inventory 
					int oldCnt = product.getItemQuantity();
					
					product.setItemQuantity(oldCnt - amt); 
					ArrayList<Product> newInven = inventory;
					
					newInven.set(i, product);
					this.setInventory(newInven);
					
					//getInventory().get(itemPos).setItemQuantity(oldCnt - amt);
				}
			}
			

			
			
		}
		

	}
	
	public void addBackInventory(Product product, int addBack) {
		int productID = product.getItemID();
		int invenIdx = 0;
		int inventoryAmt;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getItemID() == productID) {

				invenIdx = i;
				if (addBack < 0 ) {
					System.out.println("ERROR: In inventory addBackInventory");
				} else {
					inventoryAmt = this.inventory.get(i).getItemQuantity() + addBack;
					this.inventory.get(invenIdx).setItemQuantity(inventoryAmt);;
				}

			}
		}
		
		
	}
	

	
}
