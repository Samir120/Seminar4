package se.kth.iv1350.saleprocess.integration;

import se.kth.iv1350.saleprocess.model.*;

/**
 * A class that represents the printer.
 * @author samiralami
 *
 */
public class Printer {
    
	/**
	 * Prints the sale process receipt.
	 * @param receipt The sale process summary.
	 */
    public void print(Receipt receipt) {
        System.out.println(receipt.receiptToString());
    }
    
}
