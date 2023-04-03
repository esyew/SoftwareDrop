package milestone;

import com.fasterxml.jackson.annotation.JsonProperty;

// This is a temporary class to hold data to serialize into a Product Array
// Couldn't figure out how to serialize into the abstract classes, will fix at a later date.

public class jsonItem {
	@JsonProperty("itemID") private int itemID;
	@JsonProperty("itemQuantity") private int itemQuantity;
	@JsonProperty("itemName") private String itemName;
	@JsonProperty("itemCategory") private String itemCategory;
	@JsonProperty("itemDescription") private String itemDescription;
	@JsonProperty("itemPrice") private double itemPrice;
	@JsonProperty("parm1") private String parm1;
	@JsonProperty("parm2") private String parm2;
	@JsonProperty("parm3") private int parm3;
	@JsonProperty("stripeID") private String stripeID;
	
	/**
	 * @return the stripeID
	 */
	public final String getStripeID() {
		return stripeID;
	}



	/**
	 * @param stripeID the stripeID to set
	 */
	public final void setStripeID(String stripeID) {
		this.stripeID = stripeID;
	}



	jsonItem() {
		
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
	 * @return the parm1
	 */
	public final String getParm1() {
		return parm1;
	}



	/**
	 * @param parm1 the parm1 to set
	 */
	public final void setParm1(String parm1) {
		this.parm1 = parm1;
	}



	/**
	 * @return the parm2
	 */
	public final String getParm2() {
		return parm2;
	}



	/**
	 * @param parm2 the parm2 to set
	 */
	public final void setParm2(String parm2) {
		this.parm2 = parm2;
	}



	/**
	 * @return the parm3
	 */
	public final int getParm3() {
		return parm3;
	}



	/**
	 * @param parm3 the parm3 to set
	 */
	public final void setParm3(int parm3) {
		this.parm3 = parm3;
	}
	
	

}
