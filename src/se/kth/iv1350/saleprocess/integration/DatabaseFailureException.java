package se.kth.iv1350.saleprocess.integration;

/**
 * The Exception thrown when a database connection error arise.
 * @author samiralami
 *
 */
public class DatabaseFailureException extends RuntimeException {
	
	/**
	 * Create a new case of the exception.
	 * @param message Some comments on the exception.
	 */
	public DatabaseFailureException(String message) {
		super(message);
	}

}
