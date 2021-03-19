package by.it.rydzeuski.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }


        int n = 0;
        while (Dispatcher.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n);
                threads.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");
    }
}
