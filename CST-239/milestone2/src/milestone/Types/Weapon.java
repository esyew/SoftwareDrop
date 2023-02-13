package milestone.Types;

import milestone.Product;

public class Weapon extends Product{

	
	private String rarity, type;
	private int damage;
	
	/**
	 * @return the rarity
	 */
	public final String getRarity() {
		return rarity;
	}

	/**
	 * @return the category
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @return the damage
	 */
	public final int getDamage() {
		return damage;
	}

	public Weapon(String rarity, String type, int damage) {
		super();
		this.rarity = rarity;
		this.type = type;
		this.damage = damage;
	}


	
}
