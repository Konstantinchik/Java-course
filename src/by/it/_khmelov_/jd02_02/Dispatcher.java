package by.it._khmelov_.jd02_02;

class Dispatcher {
    final static int K_SPEED = 100;
    final static int PLAN = 100;
    private volatile static int buyersInMarket = 0;
    private volatile static int buyersCompleted = 0;

    public static void reset() {
        buyersCompleted = 0;
        buyersInMarket = 0;
    }

    static void addBuyer() {
        synchronized (Dispatcher.class) {
            buyersInMarket++;
        }
    }

    static synchronized void completeBuyer() {
        buyersInMarket--;
        buyersCompleted++;
    }

    static boolean marketIsOpened() {
        return buyersInMarket + buyersCompleted != PLAN;
    }

    static boolean marketIsClosed() {
        return buyersCompleted == PLAN;
    }


}
