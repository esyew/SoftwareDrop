package milestone;


import milestone.Types.Health;
import milestone.Types.Armor;
import milestone.Types.Weapon;


public class Product {
//int itemID, String itemName, String itemCategory, String itemDescription, double itemPrice, int itemQuantity, bool itemOnShelf

	
	private int itemID, itemQuantity;
	private String itemName, itemCategory, itemDescription;
	private double itemPrice;
	
	private Weapon weapon;
	private Armor armor;
	private Health health;
	
	
	public Product() {
		
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
	public final void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the itemQuantity
	 */
	public final int getItemQuantity() {
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
	public final void setItemName(String itemName) {
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
	public final void setItemCategory(String itemCategory) {
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
	public final void setItemDescription(String itemDescription) {
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
	public final void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the weapon
	 */

	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon sets a Weapon
	 */


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}







	public void setRecoveryRate(Health health) {
		this.health = health;
	}



	public Armor GetArmor() {
		return armor;
	}



	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public Health getHealth() {
		return health;
	}



	public void setHealth(Health health) {
		this.health = health;
	}


	public void displayProduct() {
		
		String[] headers = {"    ", itemName};
	    Table inventoryTable = new Table(headers);
	    
	    
	    //Create product table
	    	inventoryTable.addRow(new String[] {"Description", itemDescription });
	    	inventoryTable.addRow(new String[] {"Category", itemCategory});
	    	inventoryTable.addRow(new String[] {"Price", "$" + String.valueOf(itemPrice)});
	    	
	    		
	    	if (itemCategory == "Weapon") {
	    		inventoryTable.addRow(new String[] {"Rarity", weapon.getRarity()});
		    		inventoryTable.addRow(new String[] {"Type", String.valueOf(weapon.getType())});
		    		inventoryTable.addRow(new String[] {"Damage", String.valueOf(weapon.getDamage())});
	    		
	    	} 
	    	else if (itemCategory == "Armor") {
	    		inventoryTable.addRow(new String[] {"Rarity", armor.getRarity()});
	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(armor.getType())});
	    		inventoryTable.addRow(new String[] {"Defense Level", String.valueOf(armor.getDefenseLevel())});
	    	} else if (itemCategory == "Health") {
	    		inventoryTable.addRow(new String[] {"Rate", health.getRate()});
	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(health.getType())});
	    		inventoryTable.addRow(new String[] {"HP", String.valueOf(health.getHP())});
	    	}
	    
	    //table.addRow(new String[] {"Lebron", "James", "LAL"});
	    
	    
	    inventoryTable.show();
		
		
		
		
		
	}



	
}
