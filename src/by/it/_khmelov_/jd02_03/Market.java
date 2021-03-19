package by.it._khmelov_.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            mainOne(args);
//        }
//    }

    public static void main(String[] args) {
        Dispatcher.reset();
        QueueBuyers queueBuyers = new QueueBuyers(30);

        System.out.println("Market opened");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i, queueBuyers);
            threadPool.execute(cashier);
        }

        int n = 0;
        while (Dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n, queueBuyers);
                buyer.start(); //threadPool.execute(buyer);
            }
            Helper.sleep(1000);
        }

        threadPool.shutdown(); //no more threads
        while (true) {
            try {
                if (threadPool.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }

}
