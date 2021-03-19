package by.it.evstratov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Marked opened");

        List<Thread> buyers = new ArrayList<>();

        int n = 0;
        int t =0;
        int expectedNumberBuyers;
        while (Dispatcher.marketIsOpened()) {
            t++;
            expectedNumberBuyers = (t-(t/30)*30) - 30 * ((t/30) % 2) + 10;
            int count = Helper.getRandom((Math.abs(expectedNumberBuyers - Dispatcher.buyersInMarket)));
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n);
                if(Dispatcher.buyersCompleted % 4 == 0){
                    buyer.setPensioneer(true);
                }
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        try {
            for (Thread thread : buyers) {
                thread.join();
            }
            for (Thread thread : QueueCashiers.getAllCashiers()) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Marked closed");

    }

}
