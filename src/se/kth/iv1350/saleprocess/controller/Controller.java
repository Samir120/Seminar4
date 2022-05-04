package se.kth.iv1350.saleprocess.controller;
import se.kth.iv1350.saleprocess.integration.*;
import se.kth.iv1350.saleprocess.model.*;
import se.kth.iv1350.saleprocess.DTO.*;

/**
 * This is the application only controller. All calls to the model passes through this class.
 * @author samiralami
 *
 */
public class Controller {
    private Sale sale;
    private EIS eis;
    private EAS eas;
    private Printer printer;
     
    /**
     * Initiates the attributes.
     * @param eis An instance for External Inventory System.
     * @param eas An instance for External Accounting System. 
     * @param printer An instance for Printer. 
     */
    public Controller(EIS eis, EAS eas, Printer printer) {
        this.eis = eis;
        this.eas = eas;
        this.printer = printer;
    }
    
    /**
     * Start a new sale.
     */
    public void startTheSale() {
        this.sale = new Sale();
    }
    
    /**
     * Puts an item to the current sale if the identifier is valid.
     * @param itemIdentifier The bar code of the item.
     * @return The item to be added as ItemDTO.
     */
    public ItemDTO addItem(String itemIdentifier) {
    	ItemDTO item = null;
        boolean itemExistInEIS = eis.itemValidity(itemIdentifier);
        if(itemExistInEIS) {
            ItemDTO itemDTO = eis.getItem(itemIdentifier);
            sale.listOfRegisteredGood(itemDTO);
            item = itemDTO;
        }
        else
        	System.out.println("The identifier " + itemIdentifier + " does not exist in EIS");
        return item;
    }
    
    /**
     * Conclude the sale process.
     * @return The total price as double.
     */
    public double endThesale() {
        return sale.endSale();
    }
    
    /**
     * Take the paid amount for current sale process and shares the sale's conclusion with other external system.
     * @param amount The amount paid by the customer.
     * @return Change value as a double.
     */
    public double payment(int amount) {
    	eas.concludeSale(sale);
        eis.concludeSale(sale);
        double change = sale.payment(amount);
        return change;
    }
    
    /*
     * Print the current sale receipt.
     */
    public void getReceipt() {
    	printer.print(new Receipt(sale));
    }
}
