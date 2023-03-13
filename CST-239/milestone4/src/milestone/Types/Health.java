package milestone.Types;

import milestone.Product;

public class Health extends Product {
	private String rate, type;
	private int hp;
	
	public Health(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, double itemPrice,String rate, String type, int hp) 
	{
		super(itemID, itemQuantity,  itemName,  itemCategory,  itemDescription, itemPrice);
		this.rate = rate;
		this.type = type;
		this.hp = hp;
	}

	public Health(Health healthOG) {
		super( healthOG.getItemID(),
				healthOG.getItemQuantity(),
				healthOG.getItemName(),
				healthOG.getItemCategory(),
				healthOG.getItemDescription(),
				healthOG.getItemPrice());
		
		setParm1(healthOG.getRate());
		setParm2(healthOG.getType());
		setParm3(healthOG.getHP());
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
	
	
	
	
	
}
