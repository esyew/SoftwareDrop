package milestone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;

import milestone.Types.Armor;
import milestone.Types.Health;
import milestone.Types.Weapon;


//https://stackoverflow.com/questions/44374706/jackson-deserialize-abstract-classes#44375706
	


public class Inventory {
	private ArrayList<Product> inventory;
	
	
	public Inventory() {
		
	}
	public ArrayList<Product> getInventory() {
		return inventory;
	}
	private void setInventory(final ArrayList<Product> inventorySet) {
		this.inventory = inventorySet;
	}
	

	// Translate json to inventory
	
	public void inventoryJson() {

		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			
			// If this file has issues, replace this for the copy firebaseDL copy.json
			List<jsonItem> productList = objectMapper.readValue(
			        new File("firebaseDL.json"), 
			        new TypeReference<List<jsonItem>>(){});
			
			for (int i = 0; i < productList.size(); i++) {
				
				//System.out.println(productList.get(i).);
				String itemCat = productList.get(i).getItemCategory();
				
			//	System.out.println(itemCat);
				
				
				if (itemCat.equals("Weapon")) {

					Weapon cw = new Weapon(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getItemPrice(),
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add(cw);

				} else if (itemCat.equals("Armor")) {
					Armor ca = new Armor(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getItemPrice(),
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add(ca);

				} else if (itemCat.equals("Health")) {

					Health ch = new Health(productList.get(i).getItemID(),
							productList.get(i).getItemQuantity(),
							productList.get(i).getItemName(),
							productList.get(i).getItemCategory(),
							productList.get(i).getItemDescription(),
							productList.get(i).getItemPrice(),
							productList.get(i).getParm1(),
							productList.get(i).getParm2(),
							productList.get(i).getParm3());
					
					inventory.add(ch);

				}
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public void resetInventory() {
		// Runs to create a blank inventory
		//inventory = new FillStore().getDefaultInventory();
		inventory = new ArrayList<Product>();
		
		
	}
	

	
	
	
	
	
	
	
	
	// Positive amt for adding, negative for removing
	public void modifyInventoryCnt(Product product, int amt) {
		int oldStock = product.getItemQuantity();
		
		//System.out.println("og amt: " + oldStock);
		if (oldStock < amt) {
			
			System.out.println("Error: you shouldn't have gotten here, this is a final check\n"
					+ "This is in Inventory.modifyInventoryCart, it is generated from the inventory quantity being less than amt taken");
		} else {
			
			
			for (int i = 0; i < getInventory().size(); i++) {
				//System.out.println("hey");
				
				
				if (getInventory().get(i).getItemID() == product.getItemID()) {
					
					
					
				//	System.out.println("The array location for the product is : " + i);
					
					
					// Modify inventory 
					int oldCnt = product.getItemQuantity();
					
					product.setItemQuantity(oldCnt - amt); 
					ArrayList<Product> newInven = inventory;
					
					newInven.set(i, product);
					this.setInventory(newInven);
					
					//getInventory().get(itemPos).setItemQuantity(oldCnt - amt);
				}
			}
			

			
			
		}
		

	}
	
	public void addBackInventory(Product product, int addBack) {
		int productID = product.getItemID();
		int invenIdx = 0;
		int inventoryAmt;
		for (int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getItemID() == productID) {

				invenIdx = i;
				if (addBack < 0 ) {
					System.out.println("ERROR: In inventory addBackInventory");
				} else {
					inventoryAmt = this.inventory.get(i).getItemQuantity() + addBack;
					this.inventory.get(invenIdx).setItemQuantity(inventoryAmt);;
				}

			}
		}
		
		
	}


	
}
