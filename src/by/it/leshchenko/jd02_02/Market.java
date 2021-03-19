package by.it.leshchenko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        System.out.println("MARKET OPEN");
        List<Thread> buyersAndCashiers = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            final Thread cashier = new Thread(new Cashier(i));
            cashier.start();
            buyersAndCashiers.add(cashier);
        }
        int number = 0;
        while (isOpened()) {
            for (int i = 0; i < Helper.random(2 + 1); i++) {
                final Buyer buyer = new Buyer(++number);
                buyer.start();
                buyersAndCashiers.add(buyer);
            }
            Helper.sleep(ControlCentre.MARKET_ENTRY_TIMEOUT);
        }
        try {
            for (Thread thread : buyersAndCashiers) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MARKET CLOSE");
    }

    static boolean isOpened() {
        return ControlCentre.getBuyersInMarket() + ControlCentre.getBuyersLeft() != ControlCentre.MAX_BUYERS;
    }

    static boolean isClosed() {
        return ControlCentre.getBuyersLeft() == ControlCentre.MAX_BUYERS;
    }
}
