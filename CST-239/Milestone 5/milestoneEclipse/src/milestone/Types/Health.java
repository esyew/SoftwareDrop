package milestone.Types;

import milestone.Product;

public class Health extends Product {
	private String rate, type;
	private int hp;
	
	public Health(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, String stripeID, double itemPrice, String rate, String type, int hp) 
	{
		super(itemID, itemQuantity,  itemName,  itemCategory,  itemDescription, itemPrice, stripeID);
		this.rate = rate;
		this.type = type;
		this.hp = hp;
	}

	public Health(Health healthOG, String parm1, String parm2, int parm3) {
		super( healthOG.getItemID(),
				healthOG.getItemQuantity(),
				healthOG.getItemName(),
				healthOG.getItemCategory(),
				healthOG.getItemDescription(),
				healthOG.getItemPrice(),
				healthOG.getStripeID());
		
		setParm1(parm1);
		setParm2(parm2);
		setParm3(parm3);
	}



	public String getRate() {
		return rate;
	}

	public String getType() {
		return type;
	}

	public int getHP() {
		return hp;
}
	

	@Override
	protected String getParm1() {
		return rate;
	
	}
	
	@Override
	protected String getParm2() {
		return type;
	
	}
	
	
	@Override
	protected int getParm3() {
		return hp;
	
	}
	
	@Override
	protected void setParm1(String setter) {
		rate = setter;
	
	}
	
	
	@Override
	protected void setParm2(String setter) {
		type = setter;
	
	}
	@Override
	protected void setParm3(int setter) {
		hp = setter;
	
	}

//	@Override
//	protected int compareTo(Weapon weaponCompare) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
	
	
	
}
