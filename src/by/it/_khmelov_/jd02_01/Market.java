package by.it._khmelov_.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            mainOne(args);
//        }
//    }

    public static void main(String[] args) {
        Dispatcher.buyersInMarket=0;
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();

        int n = 0;
        for (int t = 1; t <= 120; t++) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++n);
                buyers.add(buyer);
                buyer.start();
                //noinspection NonAtomicOperationOnVolatileField
                Dispatcher.buyersInMarket++;
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
        System.out.println("Market closed");
    }

}
