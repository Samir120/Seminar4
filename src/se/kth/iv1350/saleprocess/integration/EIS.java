
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
     */
    public ItemDTO getItem(String itemIdentifier){
        ItemDTO result = null;
        for(ItemDTO itemDTO : listOfItems)
            if(itemDTO.getItemIdentifier().equals(itemIdentifier))
                result = itemDTO;
        return result;
    }
    
    /**
     * 
     * @param itemIdentifier
     * @return
     */
    public Boolean itemValidity(String itemIdentifier) {
        Boolean result = false;
        for(ItemDTO itemDTO : listOfItems)
            if(itemDTO.getItemIdentifier().equals(itemIdentifier))
                result = true;
        return result;
    }
    
    /**
	 * Concludes the current sale process and updates the EIS.
	 * @param sale The current sale to concluded.
	 */
    public void concludeSale(Sale sale) {
        System.out.println("From EIS: Concluding the sale... ");
    }
    
}
