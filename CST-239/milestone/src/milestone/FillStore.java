package milestone;
import java.util.ArrayList;



import milestone.Types.Armor;
import milestone.Types.Health;
import milestone.Types.Weapon;

//This is designed to fill the store with sample data
//Runs at start of execution, never again.

//Data is provided using amazon.com
public class FillStore {
	private ArrayList<Product> defaultInventory;
	private Product currentItem;

	private Health currentHealth;
	private Armor currentArmor;
	private Weapon currentWeapon;

	public ArrayList<Product> FillStore() {
		defaultInventory = new ArrayList<Product>();
		
		
		
		//Set Weapon
		
			//Golden Sword
			
			currentItem = new Product();
			currentItem.setItemID(11);
			currentItem.setItemName("Golden Sword");
			currentItem.setItemCategory("Weapon");
			currentItem.setItemDescription("Can be used to defeat most ogres");
			currentItem.setItemPrice(4.99);
			currentItem.setItemQuantity(15);
			currentWeapon = new Weapon("Common", "Sword", 600);
			currentItem.setWeapon(currentWeapon);
			defaultInventory.add(currentItem);
			
			
			currentItem = new Product();
			currentItem.setItemID(12);
			currentItem.setItemName("Ancient Mace");
			currentItem.setItemCategory("Weapon");
			currentItem.setItemDescription("Traditional Ogre fighting gear");
			currentItem.setItemPrice(7.99);
			currentItem.setItemQuantity(10);
			currentWeapon = new Weapon("Abnorbal", "Mace", 1200);
			currentItem.setWeapon(currentWeapon);
			defaultInventory.add(currentItem);
			
			
			
			

			//Golden Chestplate
			
			currentItem = new Product();
			currentItem.setItemID(13);
			currentItem.setItemName("Golden Chestplate");
			currentItem.setItemCategory("Armor");
			currentItem.setItemDescription("Defends against most sub-1000 attack level weapons");
			currentItem.setItemPrice(9.99);
			currentItem.setItemQuantity(19);
			currentArmor = new Armor("Common", "Chestplate", 1000);
			currentItem.setArmor(currentArmor);
			defaultInventory.add(currentItem);
			
			//Power Up Level 3
			currentItem = new Product();
			currentItem.setItemID(14);
			currentItem.setItemName("Diamond Chestplate");
			currentItem.setItemCategory("Armor");
			currentItem.setItemDescription("Defends nearly all enemies");
			currentItem.setItemPrice(19.99);
			currentItem.setItemQuantity(19);
			currentArmor = new Armor("Rare", "Chestplate", 3000);
			currentItem.setArmor(currentArmor);
			defaultInventory.add(currentItem);


		
		
		
		
		
		//Health
			//Extra Life
			
			currentItem = new Product();
			currentItem.setItemID(31);
			currentItem.setItemName("One extra Life");
			currentItem.setItemCategory("Health");
			currentItem.setItemDescription("Get an extra life, is it fair? no!");
			currentItem.setItemPrice(4.99);
			currentItem.setItemQuantity(29);
			currentHealth = new Health("NA", "Extra Life", 1000);
			currentItem.setHealth(currentHealth);
			
			defaultInventory.add(currentItem);
		
			
			currentItem = new Product();
			currentItem.setItemID(32);
			currentItem.setItemName("Stronger Health");
			currentItem.setItemCategory("Health");
			currentItem.setItemDescription("Increase the damage your player can take");
			currentItem.setItemPrice(7.99);
			currentItem.setItemQuantity(19);
			currentHealth = new Health("2x", "Player Health", 2000);
			currentItem.setHealth(currentHealth);
			
			defaultInventory.add(currentItem);
		
			
			
/*

		
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
			
			*/
			
		
		return defaultInventory;
	}

	public ArrayList<Product> getDefaultInventory() {
		defaultInventory = FillStore();
		return defaultInventory;
	}

	
}
