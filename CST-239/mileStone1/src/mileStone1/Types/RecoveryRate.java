package mileStone1.Types;

public class RecoveryRate {
	private String rate, type;
	private int hp;
	
	public RecoveryRate(String rate, String type, int hp) {
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
