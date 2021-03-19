package by.it.rydzeuski.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args)  {

        QueueBuyers queueBuyers=new QueueBuyers(30);
        System.out.println("Market opened");

        ExecutorService threadCashier = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i,queueBuyers);
            threadCashier.execute(cashier);
        }

        int n = 0;
        while (Dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n,queueBuyers);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        threadCashier.shutdown();
        while (true) {
            try {
                if (threadCashier.awaitTermination(10, TimeUnit.DAYS)) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Market closed");
    }
}
