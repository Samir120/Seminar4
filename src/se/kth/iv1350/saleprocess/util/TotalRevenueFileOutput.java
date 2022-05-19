package se.kth.iv1350.saleprocess.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import se.kth.iv1350.saleprocess.model.SaleObserver;

/**
 * Prints the total revenue to the file totalRevenue-log.txt since the program has started.
 * @author samiralami
 *
 */
public class TotalRevenueFileOutput implements SaleObserver {
	private double totalRevenue;
	private PrintWriter logStream;
	
	/**
	 * Initiate an instance of the file.
	 */
	public TotalRevenueFileOutput() {
		try {
			logStream = new PrintWriter(
						new FileWriter("totalRevenue-log.txt"), true);
		}
		catch(IOException ioe) {
			System.out.println("Failed to create logger.");
			ioe.printStackTrace();
		}
	}
	
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
	 * Prints the total revenue to the file.
	 */
	private void printTotalRevenue() {
		StringBuilder sb = new StringBuilder();
        
        sb.append("\n.........TOTAL REVENUE.........\n");
        sb.append(createTime() + "\n");
		String stringFormat = String.format("%s  %.5s", "Total revenue: ", totalRevenue);
		sb.append(stringFormat);
		sb.append("\n...............................\n");
		logStream.println(sb);
	}
	
	/**
	 * Creates date and time of the file.
	 * @return
	 */
	public String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
	

}
