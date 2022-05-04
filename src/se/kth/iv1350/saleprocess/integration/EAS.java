package se.kth.iv1350.saleprocess.integration;
import se.kth.iv1350.saleprocess.model.*;

/**
 * This is an external accounting system for the application.
 * @author samiralami
 */
public class EAS {
    
	/**
	 * Concludes the current sale process and updates the EAS.
	 * @param sale The current sale to concluded.
	 */
    public void concludeSale(Sale sale) {
        System.out.println("From EAS: Concluding the sale ...");
    }
}
