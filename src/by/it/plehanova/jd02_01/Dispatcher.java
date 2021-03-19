package by.it.plehanova.jd02_01;

class Dispatcher {
    static final int K_SPEED = 100;
    private volatile static int buyersInMarket = 0;
    private volatile static int buyersCompleted = 0;

    public static int getBuyersInMarket() {
        return buyersInMarket;
    }

    static synchronized void enter() {
        buyersInMarket++;
    }

    static synchronized void goOut() {
        buyersInMarket--;
        buyersCompleted++;
    }

    public static int getAllBuyers() {
        return buyersInMarket + buyersCompleted;
    }
}
