package se.kth.iv1350.saleprocess.controller;

import se.kth.iv1350.saleprocess.integration.*;
import se.kth.iv1350.saleprocess.util.*;
import se.kth.iv1350.saleprocess.model.*;
import se.kth.iv1350.saleprocess.DTO.*;
import java.util.ArrayList;
import java.util.List;


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
    private ScreenLogger screenLogger;
    private FileLogger fileLogger;
    private List<SaleObserver> saleObservers = new ArrayList<>();
     
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
        this.screenLogger = ScreenLogger.getLogger();
        this.fileLogger = FileLogger.getLogger();
    }
    
    /**
     * Start a new sale.
     */
    public void startTheSale() {
        this.sale = new Sale();
        sale.addSaleObserver(saleObservers);
    }
    
    /**
     * Puts an item to the current sale if the identifier is valid.
     * @param itemIdentifier The bar code of the item.
     * @return The item to be added as ItemDTO.
     * @throws InvalidItemIdentifierException if an item is not fetched for an invalid identifier.
     * @throws DatabaseFailureException if a connection to the EIS is not builded up.
     */
    public ItemDTO addItem(String itemIdentifier) throws InvalidItemIdentifierException, 
    													DatabaseFailureException {
    	ItemDTO itemDTO = null;
    	try {
    			itemDTO = eis.getItem(itemIdentifier);
    			sale.listOfRegisteredGood(itemDTO);
    		}
    	catch (InvalidItemIdentifierException e) {
    		screenLogger.log(e);
    		fileLogger.log(e);
    	}
    	
    	catch (DatabaseFailureException e) {
    		screenLogger.log(e);
    		fileLogger.log(e);
    	}
    	
    	return itemDTO;
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
    
    /**
     * Specify notification for sales that are initiated after this method is invoked.
     * @param observer
     */
    public void addSaleObserver(SaleObserver observer) {
    	saleObservers.add(observer);
    }
}
