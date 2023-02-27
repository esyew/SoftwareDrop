package milestone.Types;

import milestone.Product;

public class Armor extends Product {
	private String rarity, type;
	private int defenseLevel;
	
	public Armor(String rarity, String type, int defenseLevel) {
		super();
		this.rarity = rarity;
		this.type = type;
		this.defenseLevel = defenseLevel;
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
}
