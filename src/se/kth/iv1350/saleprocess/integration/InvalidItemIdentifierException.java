package se.kth.iv1350.saleprocess.integration;

/**
 * The Exception thrown when an identifier is not corresponded with an item in the EIS.
 * @author samiralami
 *
 */
public class InvalidItemIdentifierException extends Exception {
	
	/**
	 * Create a new case of the exception.
	 * @param message Some comments on the exception.
	 */
	public InvalidItemIdentifierException(String message) {
		super(message);
	}

}
