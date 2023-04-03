

package milestone;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import milestone.Types.Weapon;

import java.io.IOException;
import java.io.Serializable;

public abstract class Product {

	// Need to port from JSON file
	@JsonProperty("itemID") private int itemID;
	@JsonProperty("itemQuantity") private int itemQuantity;
	@JsonProperty("itemName") private String itemName;
	@JsonProperty("itemCategory") private String itemCategory;
	@JsonProperty("itemDescription") private String itemDescription;
	@JsonProperty("itemPrice") private double itemPrice;
	@JsonProperty("stripeID") private String stripeID;
	
	
	


	protected Product(int itemID, int itemQuantity, String itemName, String itemCategory, String itemDescription, double itemPrice, String stripeID) {
		this.itemID = itemID;
		this.itemQuantity = itemQuantity;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.stripeID = stripeID;
		
	}
	
	protected Product() {
		// No arg constructor
		
	}
	
	
	
	

	// Copy constructor for adding product to shoppingCart
	// Note, this might not be supposed to be here
	protected Product(Product og) {
		this.setItemID(og.getItemID());
		this.setItemQuantity(og.getItemQuantity());
		this.setItemName(og.getItemName());
		this.setItemCategory(og.getItemCategory());
		this.setItemDescription(og.getItemDescription());
		this.setItemPrice(og.getItemPrice());
		this.setStripeID(og.getStripeID());
	
		
		// Add copy constructor for subclasses
		this.setParm1(og.getParm1());
		this.setParm2(og.getParm2());
		this.setParm3(og.getParm3());
		
		
	}





	
	/**
	 * @return the itemID
	 */
	public final int getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	private final void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the itemQuantity
	 */
	public final int getItemQuantity() {
		
		if (itemQuantity < 0) {
			System.out.println("ERROR: " + getItemName() + " has a invalid amt.");
			setItemQuantity(0);
		}
		
		
		
		
		return itemQuantity;
	}


	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public final void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	
	
	
	/**
	 * @return the stripeID
	 */
	public final String getStripeID() {
		return stripeID;
	}

	/**
	 * @param stripeID the stripeID to set
	 */
	public final void setStripeID(String stripeID) {
		this.stripeID = stripeID;
	}

	/**
	 * @return the itemName
	 */
	public final String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	private final void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemCategory
	 */
	public final String getItemCategory() {
		return itemCategory;
	}
	/**
	 * @param itemCategory the itemCategory to set
	 */
	private final void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	/**
	 * @return the itemDescription
	 */
	public final String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @param itemDescription the itemDescription to set
	 */
	protected final void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	
	/**
	 * @return the itemPrice
	 */
	public final double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	private final void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	protected abstract String getParm1();
	protected abstract String getParm2();
	protected abstract int getParm3();

	protected abstract void setParm1(String setter);
	protected abstract void setParm2(String setter);
	protected abstract void setParm3(int setter);
	
	//protected abstract int compareTo(Weapon weaponCompare);

	// overriding the compareTo method of Comparable class

	// overriding the compareTo method of Comparable class





//	public static class ProductDeserializer extends StdDeserializer<Product> {
//		protected ProductDeserializer() {
//			this(null);
//		}
//
//		protected ProductDeserializer(final Class<?> vc) {
//			super(vc);
//		}
//
//		@Override
//		public Product deserialize(final JsonParser parser, final DeserializationContext context)
//				throws IOException, JsonProcessingException {
//			final JsonNode node = parser.getCodec().readTree(parser);
//			final ObjectMapper mapper = (ObjectMapper)parser.getCodec();
//			if (node.has("aGoodBoy")) {
//				return mapper.treeToValue(node, Dog.class);
//			} else {
//				return mapper.treeToValue(node, Fish.class);
//			}
//		}
//	}
}

	



