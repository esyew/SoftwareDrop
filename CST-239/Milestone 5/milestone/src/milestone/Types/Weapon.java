package milestone.Types;

import com.fasterxml.jackson.annotation.JsonProperty;

import milestone.Product;

public class Weapon extends Product{

	// Weapon only data
	@JsonProperty("rarity") private String rarity;
	@JsonProperty("type") private String type;
	@JsonProperty("damage") private int damage;
	
	// Constructors
	
	public Weapon(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, double itemPrice, String stripeID, String rarity, String type, int damage) {
	super(itemID, itemQuantity,  itemName,  itemCategory,  itemDescription, itemPrice, stripeID);
	setRarity(rarity);
	setType(type);
	setDamage(damage);
	

}
	public Weapon(Product weaponOG, String parm1, String parm2, int parm3) {
		super( weaponOG.getItemID(),
				weaponOG.getItemQuantity(),
				weaponOG.getItemName(),
				weaponOG.getItemCategory(),
				weaponOG.getItemDescription(),
				weaponOG.getItemPrice(),
				weaponOG.getStripeID());
		
		setRarity(parm1);
		setType(parm2);
		setDamage(parm3);
	}
	@Override
	protected String getParm1() {
		return rarity;
	
	}
	
	@Override
	protected String getParm2() {
		return type;
	
	}
	
	
	@Override
	protected int getParm3() {
		return damage;
	
	}
	
	@Override
	protected void setParm1(String setter) {
		rarity = setter;
	
	}
	
	
	@Override
	protected void setParm2(String setter) {
		type = setter;
	
	}
	@Override
	protected void setParm3(int setter) {
		damage = setter;
	
	}
	

	
	
	
	
	
	
public int compareTo(Weapon weaponCompare) {

	if (weaponCompare.getItemName() == this.getItemName()) {
		return 0;
	} else {
		return  this.getItemName().compareTo(weaponCompare.getItemName());
	}

	
}
//
//	@Override
//	public int compareTo() {
//		// TODO Auto-generated method stub
//		return 0;
//	}


	public String getType() {
		return type;
	}
	@SuppressWarnings("unused")
	private void setType(final String type) {
		this.type = type;
	}
	public String getRarity() {
		return rarity;
	}
	private void setRarity(final String rarity) {
		this.rarity = rarity;
	}
	public int getDamage() {
		return damage;
	}
	@SuppressWarnings("unused")
	private void setDamage(final int damage) {
		this.damage = damage;
	}
	
	
	
	
	
	
	
	


	

	
}
