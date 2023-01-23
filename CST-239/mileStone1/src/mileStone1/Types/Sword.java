//Erick Grant
//CST-239
//My own work
package mileStone1.Types;

public class Sword {

	
	private String type, defense;
	private int hp;
	/**
	 * 
	 * @param type
	 * @param defense
	 * @param hp
	 *  
	 */
	public Sword(String type, String defense, int hp) {
		super();
		this.type = type;
		this.defense = defense;
		this.hp = hp;
	}

	public String getType() {
		return type;
	}

	public String getDefense() {
		return defense;
	}

	public int getHP() {
		return hp;
	}
	
}
