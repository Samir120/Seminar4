package se.kth.iv1350.saleprocess.startup;

import se.kth.iv1350.saleprocess.integration.*;
import se.kth.iv1350.saleprocess.controller.*;
import se.kth.iv1350.saleprocess.view.*;

/**
 * Execute an instance of the application.
 * @author samiralami
 */
public class Main {
    public static void main(String[] args) {
        EIS eis = new EIS();
        EAS eas = new EAS();
        Printer printer = new Printer();
        Controller contr = new Controller(eis, eas, printer);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
