package se.kth.iv1350.saleprocess.util;

/**
 * Specifies an object that interested to print to an output system.
 * @author samiralami
 *
 */
public interface Logger {
	
	/**
	 * An exception to be printed to a log.
	 * @param exception The specified exception to be printed.
	 */
	void log(Exception exception);
	
	/**
	 * Create date and time for a log.
	 * @return The time as a string.
	 */
	String createTime();

}
