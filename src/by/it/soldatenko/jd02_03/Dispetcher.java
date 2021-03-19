package by.it.soldatenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {
    final static int K_SPEED = 1000;
    final static int PLAN = 100;
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersComplete = new AtomicInteger(0);

    public static void reset() {
        buyersComplete.set(0);
        buyersInMarket.set(0);
    }

    static void addBuyer() {

        buyersInMarket.getAndIncrement();

    }

    static synchronized void completeBuyer() {
        buyersInMarket.getAndDecrement();
        buyersComplete.getAndIncrement();
    }

    static boolean marketIsOpened() {
        return buyersInMarket.get() + buyersComplete.get() != PLAN;
    }

    static boolean marketIsClosed() {
        return buyersComplete.get() == PLAN;
    }

}
