

package milestone;

import com.fasterxml.jackson.annotation.JsonProperty;

import milestone.Types.Weapon;

public abstract class Product {
	@JsonProperty("itemID") private int itemID;
	@JsonProperty("itemQuantity") private int itemQuantity;
	@JsonProperty("itemName") private String itemName;
	@JsonProperty("itemCategory") private String itemCategory;
	@JsonProperty("itemDescription") private String itemDescription;
	@JsonProperty("JsonName1") private double itemPrice;
	
	
	
	


	protected Product(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, double itemPrice) {
		this.itemID = itemID;
		this.itemQuantity = itemQuantity;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		
	}
	
	protected Product() {
		// No arg constructor
		
	}
	
	
	
	

	// Copy constructor for adding product to shoppingCart
	// Note, this might not be supposed to be here
	protected Product(Product og) {
		this.setItemID(og.getItemID());
		this.setItemQuantity(og.getItemQuantity());
		this.setItemName(og.getItemName());
		this.setItemCategory(og.getItemCategory());
		this.setItemDescription(og.getItemDescription());
		this.setItemPrice(og.getItemPrice());
	
		
		// Add copy constructor for subclasses
		this.setParm1(og.getParm1());
		this.setParm2(og.getParm2());
		this.setParm3(og.getParm3());
		
		
	}
	
	
	/**
	 * @return the itemID
	 */
	public final int getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	private final void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the itemQuantity
	 */
	public final int getItemQuantity() {
		
		if (itemQuantity < 0) {
			System.out.println("ERROR: " + getItemName() + " has a invalid amt.");
			setItemQuantity(0);
		}
		
		
		
		
		return itemQuantity;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public final void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @return the itemName
	 */
	public final String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	private final void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemCategory
	 */
	public final String getItemCategory() {
		return itemCategory;
	}
	/**
	 * @param itemCategory the itemCategory to set
	 */
	private final void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	/**
	 * @return the itemDescription
	 */
	public final String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @param itemDescription the itemDescription to set
	 */
	protected final void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	/**
	 * @return the itemPrice
	 */
	public final double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	private final void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	protected abstract String getParm1();
	protected abstract String getParm2();
	protected abstract int getParm3();

	protected abstract void setParm1(String setter);
	protected abstract void setParm2(String setter);
	protected abstract void setParm3(int setter);
	
	protected abstract int compareTo(Weapon weaponCompare);
	
	
	
}






//package milestone;
//
//
//import milestone.Types.Health;
//import milestone.Types.Armor;
//import milestone.Types.Weapon;
//
//
//public abstract class  Product {
////int itemID, String itemName, String itemCategory, String itemDescription, double itemPrice, int itemQuantity, bool itemOnShelf
//
//	
//	private int itemID, itemQuantity;
//	private String itemName, itemCategory, itemDescription;
//	private double itemPrice;
//	
//	private Weapon weapon;
//	private Armor armor;
//	private Health health;
//	
//	
	
//
//	/**
//	 * @return the weapon
//	 */
//
//	public Weapon getWeapon() {
//		return weapon;
//	}
//
//	/**
//	 * @param weapon sets a Weapon
//	 */
//
//
//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}
//
//
//
//
//
//
//
//
//
//
//
//	public Armor GetArmor() {
//		return armor;
//	}
//
//
//
//	public void setArmor(Armor armor) {
//		this.armor = armor;
//	}
//	
//	public Health getHealth() {
//		return health;
//	}
//
//
//
//	public void setHealth(Health health) {
//		this.health = health;
//	}
//
//// Be good to move this to StoreFront
////	public void displayProduct() {
////		
////		String[] headers = {"    ", itemName};
////	    Table inventoryTable = new Table(headers);
////	    
////	    
////	    //Create product table
////	    	inventoryTable.addRow(new String[] {"Description", itemDescription });
////	    	inventoryTable.addRow(new String[] {"Category", itemCategory});
////	    	inventoryTable.addRow(new String[] {"Price", "$" + String.valueOf(itemPrice)});
////	    	
////	    		
////	    	if (itemCategory == "Weapon") {
////	    		inventoryTable.addRow(new String[] {"Rarity", weapon.getRarity()});
////		    		inventoryTable.addRow(new String[] {"Type", String.valueOf(weapon.getType())});
////		    		inventoryTable.addRow(new String[] {"Damage", String.valueOf(weapon.getDamage())});
////	    		
////	    	} 
////	    	else if (itemCategory == "Armor") {
////	    		inventoryTable.addRow(new String[] {"Rarity", armor.getRarity()});
////	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(armor.getType())});
////	    		inventoryTable.addRow(new String[] {"Defense Level", String.valueOf(armor.getDefenseLevel())});
////	    	} else if (itemCategory == "Health") {
////	    		inventoryTable.addRow(new String[] {"Rate", health.getRate()});
////	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(health.getType())});
////	    		inventoryTable.addRow(new String[] {"HP", String.valueOf(health.getHP())});
////	    	}
////	    
////	    //table.addRow(new String[] {"Lebron", "James", "LAL"});
////	    
////	    
////	    inventoryTable.show();
////		
////		
////		
////		
////		
////	}
//
//
//
//	
//}
