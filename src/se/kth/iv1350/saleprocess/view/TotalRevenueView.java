package se.kth.iv1350.saleprocess.view;
import se.kth.iv1350.saleprocess.model.*;

/**
 * Display the total revenue to a screen since the program has started.
 * @author samiralami
 *
 */
public class TotalRevenueView implements SaleObserver {
	
	private double totalRevenue;
	
	/**
	 * Invoked when a sale has been paid.
	 * @param revenue The revenue that comes from each new sale.
	 */
	@Override
	public void newSale(double totalPrice) {
		totalRevenue += totalPrice;
		printTotalRevenue();
	}
	
	/**
	 * Prints the total revenue to the console.
	 */
	private void printTotalRevenue() {
		StringBuilder sb = new StringBuilder();
        
        sb.append("\n.........TOTAL REVENUE.........\n");
		String stringFormat = String.format("%s  %.5s", "Total revenue: ", totalRevenue);
		sb.append(stringFormat);
		sb.append("\n...............................\n");
        System.out.println(sb);
	}
	
}
