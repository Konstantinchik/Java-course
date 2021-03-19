package by.it.soldatenko.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {
        Dispetcher.reset();
        QueueBuyers queueBuyers=new QueueBuyers(30);
        System.out.println("Market opened");
        ExecutorService threadCashier = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i,queueBuyers);
            threadCashier.execute(cashier);
        }
        threadCashier.shutdown();
        int n = 0;
        while (Dispetcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count && Dispetcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n,queueBuyers);
                buyer.start();
            }
            Helper.sleep(1000 / Dispetcher.K_SPEED);
        }
        for (; ; ) {
            try {
                if (threadCashier.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
        }
        System.out.println(" Market closed");
//        System.out.println("customers " + n);

    }
}