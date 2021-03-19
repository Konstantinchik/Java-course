package by.it.evstratov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Marked opened");

        List<Buyer> buyers = new ArrayList<>();
        int n = 0;
        int expectedNumberBuyers = 0;
        for (int t = 0; t < 120; t++) {
            expectedNumberBuyers = Math.abs((t-(t/30)*30) - 30 * ((t/30) % 2)) + 10;
            int count = Helper.getRandom((expectedNumberBuyers - Dispatcher.buyersInMarket));
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++n);
                if(Dispatcher.allBuyersInMarket % 4 == 0){
                    buyer.setPensioneer(true);
                }
                buyers.add(buyer);
                buyer.start();
                Dispatcher.buyersInMarket++;
                Dispatcher.allBuyersInMarket++;
            }
            Helper.sleep(1000);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Marked closed");

    }

}
