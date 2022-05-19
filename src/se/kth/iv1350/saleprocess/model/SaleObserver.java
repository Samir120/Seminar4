package se.kth.iv1350.saleprocess.model;

/**
 * An interface for observing changes in total revenue. Any class that is interested for notification of changes
 * implements this interface, and the object created with that class is registered with
 * {@link se.kth.iv1350.saleprocess.controller.Controller#addSaleObserver(SaleObserver)}. Once a sale has been
 * paid, that object's {@link #newSale newSale} method is invoked.
 * @author samiralami
 *
 */
public interface SaleObserver {
	
	/**
	 * Invoked when a sale has been paid.
	 * @param revenue The revenue that comes from each new sale.
	 */
	public void newSale(double revenue);
	
}
