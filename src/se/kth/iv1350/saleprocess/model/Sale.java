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
    private List<SaleObserver> saleObservers = new ArrayList<>();
    
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
        else 
        	incrementSoldGoodsQuantity(soldGood.getItemIdentifier());
    }
    
    /**
     * Recognize the item that already has been added to the registeredGoods.
     * @param soldGood The item that needs to check for multiplicity.
     * @return The result as a boolean.
     */
    private boolean itemHasAlreadyBeenAdded(ItemDTO soldGood){
        boolean result = false;
        for(ItemDTO itemDTO : registeredGoods)
            if(itemDTO.getItemIdentifier().equals(soldGood.getItemIdentifier()))
                result = true;
        return result;
    }
    
    /**
     * Increase the quantity of multiple item.
     * @param itemIdentifier The identifier of the item. 
     */
    public void incrementSoldGoodsQuantity(String itemIdentifier) {
        for(ItemDTO itemDTO : registeredGoods)
            if(itemDTO.getItemIdentifier().equals(itemIdentifier)) {
            	int incrementedQuantity = itemDTO.getSoldQuantity() + 1;
            	itemDTO.setSoldQuantity(incrementedQuantity);            	
            }
               
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
        notifyObservers();
        return change;
    }
    
    private void notifyObservers() {
    	for(SaleObserver observer : saleObservers)
    		observer.newSale(totalPrice);
    }
    
    /**
     * Gets the list of sold items.
     * @return The list of sold items as ItemDTO. 
     */
    public List<ItemDTO> getRegisteredGoods() {
        return registeredGoods;
    }
    
    public void addSaleObserver(List<SaleObserver> onservers) {
    	saleObservers.addAll(onservers);
    }
  
}
