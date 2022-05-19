package se.kth.iv1350.saleprocess.startup;

import se.kth.iv1350.saleprocess.integration.*;
import se.kth.iv1350.saleprocess.controller.*;
import se.kth.iv1350.saleprocess.view.*;

/**
 * Execute an instance of the application.
 * @author samiralami
 */
public class Main {
	
	/**
	 * Executes the application.
	 * @param args the command line parameter.
	 * @throws InvalidItemIdentifierException if an item is not fetched for an invalid identifier.
     * @throws DatabaseFailureException if a connection to the EIS is not builded up.
	 */
    public static void main (String[] args) throws InvalidItemIdentifierException, 
											DatabaseFailureException {
        EIS eis = new EIS();
        EAS eas = new EAS();
        Printer printer = new Printer();
        Controller contr = new Controller(eis, eas, printer);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
