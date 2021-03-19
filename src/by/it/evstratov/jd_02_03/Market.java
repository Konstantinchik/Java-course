package by.it.evstratov.jd_02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {

    public static void main(String[] args) {

        QueueBuyers queueBuyers = new QueueBuyers(30);

        System.out.println("Marked opened");
        ExecutorService threadPool = Executors.newFixedThreadPool(5 + Dispatcher.PLAN);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i, queueBuyers);
            QueueCashiers.getAllCashiers().add(cashier);
            threadPool.execute(cashier);
        }
        int n = 0;
        int t =0;
        int expectedNumberBuyers;
        while (Dispatcher.marketIsOpened()) {
            t++;
            expectedNumberBuyers = (t-(t/30)*30) - 30 * ((t/30) % 2) + 10;
            int count = Helper.getRandom((Math.abs(expectedNumberBuyers - Dispatcher.buyersInMarket.get())));
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n, queueBuyers);
                if(Dispatcher.buyersCompleted.get() % 4 == 0){
                    buyer.setPensioneer(true);
                }
                threadPool.execute(buyer);

            }
            Helper.sleep(1000);
        }
        threadPool.shutdown();

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
