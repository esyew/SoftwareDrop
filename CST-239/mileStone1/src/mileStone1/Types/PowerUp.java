//Erick Grant
//CST-239
//My own work
package mileStone1.Types;

public class PowerUp {
	private String rarity, type;
	private int hp;
	/**
	 * 
	 * @param rarity
	 * @param type
	 * @param hp
	 */
	public PowerUp(String rarity, String type, int hp) {
		super();
		this.rarity = rarity;
		this.type = type;
		this.hp = hp;
	}

	public String getType() {
		return type;
	}

	public String getRarity() {
		return rarity;
	}

	public int getHP() {
		return hp;
	}
}
