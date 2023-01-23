package mileStone1;
import java.util.ArrayList;



import mileStone1.Types.PowerUp;
import mileStone1.Types.RecoveryRate;
import mileStone1.Types.Sword;

//This is designed to fill the store with sample data
//Runs at start of execution, never again.

//Data is provided using amazon.com
public class FillStore {
	private ArrayList<Product> defaultInventory;
	private Product currentItem;

	private PowerUp currentPowerUp;
	private RecoveryRate recoveryRate;
	private Sword currentSword;

	public ArrayList<Product> FillStore() {
		defaultInventory = new ArrayList<Product>();
		
		
		
		//Set Books
		
			//Power Up Level 1
			
			currentItem = new Product();
			currentItem.setItemID(11);
			currentItem.setItemName("Power up Level 1");
			currentItem.setItemCategory("Power Up");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Can be used to defeat most ogres");
			currentItem.setItemPrice(4.99);
			currentItem.setItemQuantity(15);
			currentPowerUp = new PowerUp("Common", "Combat Level 1 ", 600);
			currentItem.setPowerUp(currentPowerUp);
			defaultInventory.add(currentItem);
			
			//Power Up Level 2
			
			currentItem = new Product();
			currentItem.setItemID(12);
			currentItem.setItemName("Power up Level 2");
			currentItem.setItemCategory("Power Up");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Can be used to defeat most giants");
			currentItem.setItemPrice(9.99);
			currentItem.setItemQuantity(10);
			currentPowerUp = new PowerUp("Rare", "Combat Level 2", 1200);
			currentItem.setPowerUp(currentPowerUp);
			defaultInventory.add(currentItem);
			
			//Power Up Level 3
			
			currentItem = new Product();
			currentItem.setItemID(13);
			currentItem.setItemName("Power up Level 3");
			currentItem.setItemCategory("Power Up");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Can be used to defeat nearly any monster, except ones with the \"Nepotism\" Power Up");
			currentItem.setItemPrice(19.99);
			currentItem.setItemQuantity(8);
			currentPowerUp = new PowerUp("Legendary", "Combat Level 3", 4000);
			currentItem.setPowerUp(currentPowerUp);
			defaultInventory.add(currentItem);
			
			
		
		
		
		
		
		//Set Recovery Rate
			//Recovery rate level 1 
			
			currentItem = new Product();
			currentItem.setItemID(21);
			currentItem.setItemName("Recovery rate level 1");
			currentItem.setItemCategory("Recovery Rate");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Heal 1.5x faster than regular rate!");
			currentItem.setItemPrice(4.99);
			currentItem.setItemQuantity(14);
			RecoveryRate currentRecoveryRate = new RecoveryRate("1.5x", "Defense", 2000);
			currentItem.setRecoveryRate(currentRecoveryRate);
			
			defaultInventory.add(currentItem);
		
			
			
			//Recovery rate level 2
			
			currentItem = new Product();
			currentItem.setItemID(22);
			currentItem.setItemName("Recovery rate level 2");
			currentItem.setItemCategory("Recovery Rate");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Heal 3x faster than regular rate!");
			currentItem.setItemPrice(19.99);
			currentItem.setItemQuantity(14);
			currentRecoveryRate = new RecoveryRate("3xs", "Defense", 4000);
			currentItem.setRecoveryRate(currentRecoveryRate);

			defaultInventory.add(currentItem);


			//Recovery 3
			

			currentItem = new Product();
			currentItem.setItemID(23);
			currentItem.setItemName("Recovery rate level 3");
			currentItem.setItemCategory("Recovery Rate");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Heal 5x faster than regular rate!");
			currentItem.setItemPrice(14.99);
			currentItem.setItemQuantity(4);
			currentRecoveryRate = new RecoveryRate("Robert Wise", "Action", 1979);
			currentItem.setRecoveryRate(currentRecoveryRate);

			defaultInventory.add(currentItem);
		
		//Set Swords
		
			//Gold Sword
			
			
			currentItem = new Product();
			currentItem.setItemID(31);
			currentItem.setItemName("Gold Sword");
			currentItem.setItemCategory("Sword");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Gold! Famously a very sturdy metal!");
			currentItem.setItemPrice(13.98);
			currentItem.setItemQuantity(2);
			currentSword = new Sword("Sporty", "Showmanship", 1000);
			currentItem.setSword(currentSword);

			defaultInventory.add(currentItem);


			//Emerald Sword

			currentItem = new Product();
			currentItem.setItemID(32);
			currentItem.setItemName("Emerald Sword");
			currentItem.setItemCategory("Sword");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("Defeats all swords below");
			currentItem.setItemPrice(24.99);
			currentItem.setItemQuantity(19);
			currentSword = new Sword("Powerful", "Attack", 2014);
			currentItem.setSword(currentSword);

			defaultInventory.add(currentItem);
		
//The Graphene Sword
			

			currentItem = new Product();
			currentItem.setItemID(33);
			currentItem.setItemName("Graphene Sword");
			currentItem.setItemCategory("Sword");
			currentItem.setItemOnShelf(true);
			currentItem.setItemDescription("You'll lose the sword before it dies");
			currentItem.setItemPrice(49.99);
			currentItem.setItemQuantity(19);
			currentSword = new Sword("Legendary", "Attack", 9999);
			currentItem.setSword(currentSword);

			defaultInventory.add(currentItem);
		
		return defaultInventory;
	}

	public ArrayList<Product> getDefaultInventory() {
		defaultInventory = FillStore();
		return defaultInventory;
	}

	
}
