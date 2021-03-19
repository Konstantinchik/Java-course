package by.it.leshchenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        System.out.println("MARKET OPEN");
        List<Buyer> buyers = new ArrayList<>();
        int number = 0;
        for (int t = 0; t < ControlCentre.MARKET_OPENTIME; t++) {
            for (int i = 0; i < Helper.random(2 + 1); i++) {
                final Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(ControlCentre.MARKET_ENTRY_TIMEOUT);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MARKET CLOSE");
    }
}
