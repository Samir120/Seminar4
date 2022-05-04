package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.*;
import se.kth.iv1350.saleprocess.DTO.*;
import se.kth.iv1350.saleprocess.model.*;

/**
 * This is a virtual screen for the user interface. Hardcoded execution created here.
 * @author samiralami
 */
public class View {
    private Controller contr;
    Sale sale = new Sale();
    
    /**
     * Creates an instance.
     * @param contr The system controller.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * A fake execution for running the application.
     */
    public void runFakeExecution() {
        contr.startTheSale();
        System.out.println(".......A new sale has been statrted.......");
        System.out.println("Scanning items...");
        String stringForamt1 = String.format("%-35s %5s", "Description",  "Price");
        String stringForamt2 = String.format("%-35s %5s", "-------------------------------", "------");
        System.out.println(stringForamt1);
        System.out.println(stringForamt2);
        
        fakeDisplay(contr.addItem("0001"));
        fakeDisplay(contr.addItem("0003"));
        fakeDisplay(contr.addItem("0004"));
        fakeDisplay(contr.addItem("0005"));
        System.out.println("..........All items are scanned..........");
        System.out.println();
        
        
        double totalPrice = contr.endThesale();
        String stringForamt3 = String.format("%s  %.5s", "Total price: ", totalPrice);
        System.out.println(stringForamt3);
        
        double change = contr.payment(400);
        String stringForamt4 = String.format("%s  %.5s", "Change: ", change);
        System.out.println(stringForamt4);
        System.out.println();
        
        contr.getReceipt();
        
    }
    
    /**
     * A fake display that used instead of real screen.
     * @param itemDTO The scanned item.
     */
    public void fakeDisplay(ItemDTO itemDTO) {
    	String stringForamt = String.format("%-35s  %3s", itemDTO.getDescription(), itemDTO.getPrice());
        System.out.println(stringForamt);
        
    }
}
