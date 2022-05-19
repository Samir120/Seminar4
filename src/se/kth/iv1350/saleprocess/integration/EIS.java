
package se.kth.iv1350.saleprocess.integration;

import se.kth.iv1350.saleprocess.DTO.*;
import se.kth.iv1350.saleprocess.model.*;
import java.util.List;
import java.util.ArrayList;

/**
 * A class that created for external inventory system.
 * @author samiralami
 */
public class EIS {
    private List<ItemDTO> listOfItems = new ArrayList<>();
    
    /**
     * Save all items to a list.
     */
    public EIS() {
        this.listOfItems.add(new ItemDTO("Barilla Spaghetti", "0001", "Pre-cooked pasta", 18.20, 0.12, 1));
        this.listOfItems.add(new ItemDTO("ZETA checkpeas", "0002", "The firm consistency of chickpeas", 15.00, 0.15, 1));
        this.listOfItems.add(new ItemDTO("FELIX tomato ketchup", "0003", "Less sugar and salt", 27.5, 0.15, 1));
        this.listOfItems.add(new ItemDTO("Russian yogurt", "0004", "Boilable, creamy and round", 32.00, 0.20, 1));
        this.listOfItems.add(new ItemDTO("BOB jam", "0005", "Raspberry jam with more berries", 35.00, 0.25, 1));
    }
    
    /**
     * Gets a specific item from the listOfItems.
     * @param itemIdentifier The identifier of an item.
     * @return The item as an ItemDTO. 
     * @throws InvalidItemIdentifierException if an item is not fetched for an invalid identifier.
     * @throws DatabaseFailureException if a connection to the EIS is not builded up.
     */
    public ItemDTO getItem(String itemIdentifier) throws InvalidItemIdentifierException,
    													DatabaseFailureException {
    	if(!itemIdentifier.equals("0000")) {
    		for(ItemDTO itemDTO : listOfItems)
                if(itemDTO.getItemIdentifier().equals(itemIdentifier))
                    return itemDTO;
            throw new InvalidItemIdentifierException("The item identifier: " + itemIdentifier + " is not valid.");
    	}
    	throw new DatabaseFailureException("Unable to connect to the database.");
    }
    
    /**
	 * Concludes the current sale process and updates the EIS.
	 * @param sale The current sale to concluded.
	 */
    public void concludeSale(Sale sale) {
        System.out.println("From EIS: Concluding the sale... ");
    }
    
}
