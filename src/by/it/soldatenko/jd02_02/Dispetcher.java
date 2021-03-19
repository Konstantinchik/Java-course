package by.it.soldatenko.jd02_02;

class Dispetcher {
    final static int K_SPEED = 1000;
    final static int PLAN = 100;
    private volatile static int buyersInMarket = 0;
    private volatile static int buyersComplete = 0;

    public static void reset() {
        buyersComplete = 0;
        buyersInMarket = 0;
    }

    static void addBuyer() {
        synchronized (Dispetcher.class) {
            buyersInMarket++;
        }
    }

    static synchronized void completeBuyer() {
        buyersInMarket--;
        buyersComplete++;
    }

    static  boolean marketIsOpened(){
        return buyersInMarket+buyersComplete!=PLAN;
    }
    static  boolean marketIsClosed(){
        return buyersComplete==PLAN;
    }

}
