package se.kth.iv1350.saleprocess.model;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import se.kth.iv1350.saleprocess.DTO.*;

/**
 * A class that represent the sale process summary.
 * @author samiralami
 */
public class Receipt {
    private Sale sale;
    private List<ItemDTO> registeredGoods = new ArrayList<>();
    
    /**
     * Creates an instance for attributes.
     * @param sale The current sale.
     */
    public Receipt(Sale sale) {
        this.sale = sale;
        this.registeredGoods = sale.getRegisteredGoods();
    }
    
    /**
     * Creates a string representation for sales summary.
     * @return
     */
    public String receiptToString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(".........PAYMENT CONFIRMATION.........\n");
        sb.append("\nGROCERY STORE AB \n");
        sb.append("Hanstavägen 51, Kista\n");
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String foramtDateTime = sale.setTimeOfSale().format(format);
        sb.append(foramtDateTime + "\n");
        sb.append("\n......................................\n");
        sb.append("\n");
        String stringForamt1 = String.format("%-20s %5s %10s\n", "Item", "Qty", "Price");
        String stringForamt2 = String.format("%-20s %5s %10s\n", "---------------------", "----", "------");
        sb.append(stringForamt1);
        sb.append(stringForamt2);
        
        double totalPrice = 0;
        double totalVAT = 0;
        double totalPriceIncludingVAT = 0;
        
        for(ItemDTO itemDTO : registeredGoods) {
        	String stringForamt3 = String.format("%-20s %5s %10s\n", itemDTO.getName(), itemDTO.getSoldQuantity(),itemDTO.getPrice());
        	sb.append(stringForamt3);
        	totalPrice += itemDTO.getPrice();
        	totalVAT += itemDTO.getVAT();
        	totalPriceIncludingVAT += (itemDTO.getPrice() + itemDTO.getVAT()) * itemDTO.getSoldQuantity();
        	
        }
        sb.append("......................................\n");
        String stringForamt4 = String.format("%-20s  %15.5s\n", "Purchased", totalPrice);
        sb.append(stringForamt4);
        String stringForamt5 = String.format("%-20s  %15.5s\n", "Total sales tax", totalVAT);
        sb.append(stringForamt5);
        String stringForamt6 = String.format("%-20s  %15.5s\n", "Total SEK", totalPriceIncludingVAT);
        sb.append(stringForamt6);
        
        return sb.toString();
        
    }
    
    
}
