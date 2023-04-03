package milestone.Types;

import milestone.Product;

public class Armor extends Product {
	private String rarity, type;
	private int defenseLevel;
	
	public Armor(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, double itemPrice, String stripeID, String rarity, String type, int defenseLevel) {
		super(itemID, itemQuantity,  itemName,  itemCategory,  itemDescription, itemPrice, stripeID);
		this.rarity = rarity;
		this.type = type;
		this.defenseLevel = defenseLevel;
	}
	
	public Armor (Product armorOG, String parm1, String parm2, int parm3) {
		super( armorOG.getItemID(),
				armorOG.getItemQuantity(),
				armorOG.getItemName(),
				armorOG.getItemCategory(),
				armorOG.getItemDescription(),
				armorOG.getItemPrice(),
				armorOG.getStripeID());
		
				setParm1(parm1);
				setParm2(parm2);
				setParm3(parm3);
		
	
	}



	public String getType() {
		return type;
	}

	public String getRarity() {
		return rarity;
	}

	public int getDefenseLevel() {
		return defenseLevel;
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
		return defenseLevel;
	
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
		defenseLevel = setter;
	
	}

//	@Override
//	protected int compareTo(Weapon weaponCompare) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
	
	
	
	
}
