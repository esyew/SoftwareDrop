//Erick Grant
//CST-239
//My own work
package mileStone1;


import mileStone1.Types.RecoveryRate;
import mileStone1.Types.PowerUp;
import mileStone1.Types.Sword;


public class Product {
//int itemID, String itemName, String itemCategory, String itemDescription, double itemPrice, int itemQuantity, bool itemOnShelf

	
	private int itemID, itemQuantity;
	private String itemName, itemCategory, itemDescription;
	private boolean itemOnShelf;
	private double itemPrice;
	private PowerUp powerUp;
	private RecoveryRate recoveryRate;
	private Sword sword;
	
	
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
	 * @return the itemOnShelf
	 */
	public final boolean isItemOnShelf() {
		return itemOnShelf;
	}
	/**
	 * @param itemOnShelf the itemOnShelf to set
	 */
	public final void setItemOnShelf(boolean itemOnShelf) {
		this.itemOnShelf = itemOnShelf;
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



	public Sword getSword() {
		return sword;
	}



	public void setSword(Sword sword) {
		this.sword = sword;
	}



	public String getRocoveryRate() {
		return recoveryRate.getRate();
	}



	public void setRecoveryRate(RecoveryRate recoveryRate) {
		this.recoveryRate = recoveryRate;
	}



	public PowerUp GetPowerUp() {
		return powerUp;
	}



	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}

	public void displayProduct() {
		
		String[] headers = {"    ", itemName};
	    Table inventoryTable = new Table(headers);
	    
	    
	    //Create product table
	    	inventoryTable.addRow(new String[] {"Description", itemDescription });
	    	inventoryTable.addRow(new String[] {"Category", itemCategory});
	    	inventoryTable.addRow(new String[] {"Price", "$" + String.valueOf(itemPrice)});
	    	
	    		
	    	if (itemCategory == "Power Up") {
	    		inventoryTable.addRow(new String[] {"Rarity", powerUp.getRarity()});
		    		inventoryTable.addRow(new String[] {"Type", String.valueOf(powerUp.getType())});
		    		inventoryTable.addRow(new String[] {"HP", String.valueOf(powerUp.getHP())});
	    		
	    	} else if (itemCategory == "Recovery Rate") {
	    		inventoryTable.addRow(new String[] {"Recovery Rate", recoveryRate.getRate()});
	    		inventoryTable.addRow(new String[] {"Type", String.valueOf(recoveryRate.getType())});
	    		inventoryTable.addRow(new String[] {"HP", String.valueOf(recoveryRate.getHP())});
	    	} else if (itemCategory == "Sword") {
	    		inventoryTable.addRow(new String[] {"Type", sword.getType()});
	    		inventoryTable.addRow(new String[] {"Defense", String.valueOf(sword.getDefense())});
	    		inventoryTable.addRow(new String[] {"HP", String.valueOf(sword.getHP())});
	    	}
	    
	    //table.addRow(new String[] {"Lebron", "James", "LAL"});
	    
	    
	    inventoryTable.show();
		
		
		
		
		
	}



	
}
