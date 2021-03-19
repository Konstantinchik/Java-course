package by.it.plehanova.jd02_02;

class Dispatcher {
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static final int MAX_CASHIERS = 5;
    private volatile static int buyersInMarket = 0;
    private volatile static int buyersCompleted = 0;
    private volatile static int openCashier = 0;

    public static synchronized int needToOpenCashier() {
        int needToOpenCashier = QueueBuyers.getQueue().size() / 5;
        if (QueueBuyers.getQueue().size() % 5 > 0) {
            needToOpenCashier++;
        }
        return needToOpenCashier;
    }

    public static final Object cashierMonitor = new Object();

    public static int getBuyersInMarket() {
        return buyersInMarket;
    }

    public static int getAllBuyers() {
        return buyersInMarket + buyersCompleted;
    }

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void goOutBuyers() {
        buyersInMarket--;
        buyersCompleted++;
    }

    public static int getOpenCashier() {
        return openCashier;
    }

    static synchronized void addCashier() {
        openCashier++;
    }

    static synchronized void closeCashier() {
        openCashier--;
    }

    static boolean marketIsOpened() {
        return buyersInMarket + buyersCompleted != PLAN;
    }

    static boolean markedIsClosed() {
        return buyersCompleted == PLAN;
    }

}
