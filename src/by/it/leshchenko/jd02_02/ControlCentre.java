package by.it.leshchenko.jd02_02;

public class ControlCentre {
//    public static final int MARKET_OPENTIME = 120; // seconds
    public static final int MARKET_SPEED = 100; // (default - 1)
    public static final int MAX_BUYERS = 100; // default - 100



    public static final int MARKET_ENTRY_TIMEOUT = 1000; // millisecond (default - 1000)
    public static final int BUYER_CHOOSE_TIME_MIN = 500; // millisecond (default - 500)
    public static final int BUYER_CHOOSE_TIME_MAX = 2000; // millisecond (default - 500)



    volatile static int buyersInMarket = 0;
    volatile static int buyersLeft = 0;

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void buyerLeft() {
        buyersInMarket--;
        buyersLeft++;
    }

    public synchronized static int getBuyersInMarket() {
        return buyersInMarket;
    }

    public synchronized static int getBuyersLeft() {
        return buyersLeft;
    }
}