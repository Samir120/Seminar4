
package se.kth.iv1350.saleprocess.DTO;

/**
 * A class that represent properties for an items. 
 * @author samiralami
 *
 */
public class ItemDTO {
    private final String name;
    private final String itemIdentifier;
    private final String description;
    private final double price;
    private final double VAT;
    private int soldQuantity;
    
    /**
     * Initiates the instance variable of <code>ItemDTO</code>.
     * @param name The name of the item.        
     * @param itemIdentifier The barcode of the item.
     * @param description Description of the item.
     * @param price The price of the item.
     * @param VAT The VAT-rate of the item. 
     * @param soldQuantity The quantity of sold good.
     */
    
    public ItemDTO(String name, String itemIdentifier, String description, double price, double VAT, int soldQuantity) {
        this.name = name;
        this.itemIdentifier = itemIdentifier;
        this.description = description;
        this.price = price;
        this.VAT = VAT;
        this.soldQuantity = soldQuantity;
    }
    
    /**
     * Returns the items name.
     * @return The name as a string. 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the items itemIdentifier.
     * @return The return value as a string. 
     */
    public String getItemIdentifier() {
        return this.itemIdentifier;
    }
    
    /**
     * Returns the items description.
     * @return The return value as a string. 
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Returns the items price.
     * @return The return value as a double. 
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Returns the items VAT.
     * @return The return value as a double. 
     */
    public double getVAT() {
        return this.VAT;
    }
    
   /**
    * Returns the sold goods quantity.
    * @return The return value as an integer. 
    */
    public int getSoldQuantity() {
        return this.soldQuantity;
    }
    
    /**
     * Increase the sold item quantity in multiple item case.
     */
    public void increaseSoldQuantity() {
        this.soldQuantity ++;
    }
    
    
}
