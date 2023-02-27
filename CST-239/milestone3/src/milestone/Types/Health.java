package milestone.Types;

import milestone.Product;

public class Health extends Product {
	private String rate, type;
	private int hp;
	
	public Health(String rate, String type, int hp) {
		super();
		this.rate = rate;
		this.type = type;
		this.hp = hp;
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
}
