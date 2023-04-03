package milestone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
//import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
//import com.fasterxml.jackson.databind.module.SimpleModule;

import milestone.Types.Armor;
import milestone.Types.Health;
import milestone.Types.Weapon;
import milestone.functions.ProductNameComparator;
import milestone.functions.ProductPriceComparator;


//https://stackoverflow.com/questions/44374706/jackson-deserialize-abstract-classes#44375706
	

// Inventory Class, container for unbought items (Copies much of the shoppingCart)
	public class Inventory<T extends Product> extends ArrayList<Product> {

		// Create an array of Products for the inventory, M5 replace this with generics
	//private ArrayList<Product> inventory;
		private List<T> inventory;
	
	/**
	 * Default constructor
	 * Empty Inventory
	 * 
	 */
	public Inventory() {
		inventory = new ArrayList<T>();
	}
	// Return a 
	/**
	 * @return product list of Inventory
	 */
	private List<T> getInventory() {
		return inventory;
	}

	public int inventoryUnqCnt() {
		return inventory.size();
	}
	private void setInventory(final List<T> inventorySet) {
		this.inventory = inventorySet;
	}
	
	/**
	 * Translate JSON to inventory
	 * @return void
	 */
	public void inventoryJson() {

		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			
			// If this file has issues, replace this for the copy firebaseDL copy.json
			// 
			List<jsonItem> productList = objectMapper.readValue(
			        new File("firebaseDL.json"), 
			        new TypeReference<List<jsonItem>>(){});
			
			for (int i = 0; i < productList.size(); i++) {
				
				//System.out.println(productList.get(i).);
				String itemCat = productList.get(i).getItemCategory();
				
			//	System.out.println(itemCat);
				
				// Convert jsonItem to Product class.
				if (itemCat.equals("Weapon")) {

					Weapon cw = new Weapon(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getItemPrice(),
							productList.get(i).getStripeID(),
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add((T) cw);

				} else if (itemCat.equals("Armor")) {
					Armor ca = new Armor(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getItemPrice(),
							productList.get(i).getStripeID(),
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add((T) ca);

				} else if (itemCat.equals("Health")) {

					Health ch = new Health(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getStripeID(),
							productList.get(i).getItemPrice(),
							
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add((T) ch);

				}
			
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	// Positive amt for adding, negative for removing
	/**
	 * Change an inventory item
	 * @param product- the product that will be modified.
	 * @param amt- amount the item will changed, negative item will add back into inventory
	 */
	public void modifyInventoryCnt(Product product, int amt) {
		int oldStock = product.getItemQuantity();
		
		//System.out.println("og amt: " + oldStock); //DEBUG Line
		if (oldStock < amt) {
			
			System.out.println("Error: you shouldn't have gotten here, this is a final check\n"
					+ "This is in Inventory.modifyInventoryCart, it is generated from the inventory quantity being less than amt taken");
		} else {
			
			// For each product type in the iventory
			for (int i = 0; i < getInventory().size(); i++) {
				//System.out.println("hey");
				
				
				if (getInventory().get(i).getItemID() == product.getItemID()) {
				
				//	System.out.println("The array location for the product is : " + i);
					
					
					// Get the current quanitity in the inventory. 
					int oldCnt = product.getItemQuantity();
					// Modify the inventory 
					product.setItemQuantity(oldCnt - amt); 
					List<T> newInven = inventory;
					
					newInven.set(i, (T) product);
					this.setInventory(newInven);
					
				}
			}}}



	// Method 2
	// Comparing two list

	public void sort(int type) { // MILESTONE 5

		switch(type) {
			case 0:
				// code block
				break;
			case 1:
				Collections.sort(this.inventory, new ProductPriceComparator());
				break;
			case 2:
				Collections.sort(this.inventory, new ProductPriceComparator());
				Collections.reverse(this.inventory);
				break;
			case 3:

				Collections.sort(this.inventory, new ProductNameComparator());
				break;
			case 4:
				Collections.sort(this.inventory, new ProductNameComparator());
				Collections.reverse(this.inventory);
				break;

			default:
				// code block
		}




	}

	public Product getItem(int pos) {
		return this.inventory.get(pos);
	}
	
	// Used for adding items back to the inventory, in case a user decides to return a item from their cart. 
	public void addBackInventory(Product product, int addBack) {
		int productID = product.getItemID();
		int invenIdx = 0;
		int inventoryAmt;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getItemID() == productID) {

				invenIdx = i;
				if (addBack < 0 ) {
					// should not get here, error handling before. 
					System.out.println("ERROR: In inventory addBackInventory, less than zero");
				} else {
					// Set the inventory to the canceled purchase. 
					inventoryAmt = this.inventory.get(i).getItemQuantity() + addBack;
					this.inventory.get(invenIdx).setItemQuantity(inventoryAmt);;
				}

			}
		}
		
		
	}

	/**
	 * 
	 * @param cart The shoppingCart that will be be added back to the inventory
	 *  Used to clear whole cart without purchasing items
	 */
	public void cancelCart(ShoppingCart cart) {
		
		for (int i = 0; i < cart.getTotalQuantity(); i++) {
			addBackInventory(cart.getItem(i), cart.getItem(i).getItemQuantity());
		}
		
	}

	
}
