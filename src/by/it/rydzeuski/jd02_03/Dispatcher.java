package by.it.rydzeuski.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    final static int K_SPEED = 10000;
    final static int PLAN = 100;
    private static final AtomicInteger bueyrsInMarket = new AtomicInteger(0);
    private static final AtomicInteger bueyrsCompleted = new AtomicInteger(0);

    static void addBueyr() {
        bueyrsInMarket.getAndIncrement();
    }

    static synchronized void completeBueyr() {
        bueyrsInMarket.getAndDecrement();
        bueyrsCompleted.getAndIncrement();

    }

    static boolean marketIsOpened() {
        return bueyrsInMarket.get() + bueyrsCompleted.get() != PLAN;
    }

    static boolean marketIsClosed() {
        return bueyrsCompleted.get() == PLAN;
    }

}
