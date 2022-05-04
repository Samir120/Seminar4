package se.kth.iv1350.saleprocess.model;
import se.kth.iv1350.saleprocess.DTO.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * A class that represents a sale and sales calculations.
 * @author samiralami
 */
public class Sale {
    private LocalDateTime saleDateAndTime;
    private final List<ItemDTO> registeredGoods = new ArrayList<>();
    private double totalPrice;
    double change;
    
    /**
     * Create an instance for <code>Sale</code>. 
     */
    public Sale() {
        saleDateAndTime = LocalDateTime.now();
    }
    
    /**
     * Adds the scanned item in a list.
     * @param soldGood The sold item.
     */
    public void listOfRegisteredGood(ItemDTO soldGood) {
        if(!itemHasAlreadyBeenAdded(soldGood))
            registeredGoods.add(soldGood);
        incrementSoldGoodsQuantity(soldGood.getItemIdentifier());
    }
    
    /**
     * Recognize the item that already has been added to the registeredGoods.
     * @param soldGood The item that needs to check for multiplicity.
     * @return The result as a boolean.
     */
    private Boolean itemHasAlreadyBeenAdded(ItemDTO soldGood){
        Boolean result = false;
        for(ItemDTO itemDTO : registeredGoods)
            if(soldGood.getItemIdentifier().equals(itemDTO.getItemIdentifier()))
                result = true;
        return result;
    }
    
    /**
     * Increase the quantity of multiple item.
     * @param itemIdentifier The identifier of the item. 
     */
    public void incrementSoldGoodsQuantity(String itemIdentifier) {
        for(ItemDTO itemDTO : registeredGoods)
            if(itemDTO.getDescription().equals(itemIdentifier))
                itemDTO.increaseSoldQuantity();
    }
    
    /**
     * Creates time of sale.
     * @return The time of sale as a LocalDateTime.
     */
    public LocalDateTime setTimeOfSale() {
        return this.saleDateAndTime;
    }
    
    /**
     * Calcualte the totalPrice including VAT.
     * @return The running total as a double.
     */
    public double calculateTotalPrice() {
       for(ItemDTO itemDTO : registeredGoods)
           totalPrice += (itemDTO.getPrice() + itemDTO.getVAT()) * itemDTO.getSoldQuantity();
       return totalPrice;
    }
    
    /**
     * Complete the current sale process.
     * @return The total price as a double.
     */
    public double endSale() {
    	totalPrice = calculateTotalPrice();
        return totalPrice; 
    }
    
    /**
     * Calculate the change for the sale process.
     * @param amount Cash amount that paid by the customer.
     * @return The value of change as double.
     */
    public double payment(int amount) {
        change = amount - totalPrice;
        return change;
    }
    
    /**
     * Gets the list of sold items.
     * @return The list of sold items as ItemDTO. 
     */
    public List<ItemDTO> getRegisteredGoods() {
        return registeredGoods;
    }
  
}
