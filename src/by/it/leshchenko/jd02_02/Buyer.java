package by.it.leshchenko.jd02_02;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;
    private boolean isRunnable;

//    volatile static int buyersInMarket = 0;
//    volatile static int buyersLeft = 0;

    public void setRunnable(boolean runnable) {
        isRunnable = runnable;
    }

//    static synchronized void addBuyer() {
//        buyersInMarket++;
//    }
//
//    static synchronized void buyerLeft() {
//        buyersInMarket--;
//        buyersLeft++;
//    }
//
//    public synchronized static int getBuyersInMarket() {
//        return buyersInMarket;
//    }
//
//    public synchronized static int getBuyersLeft() {
//        return buyersLeft;
//    }

    public Buyer(int i) {
        super("Buyer #" + i);
        ControlCentre.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
        ControlCentre.buyerLeft();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.getName() + " started to choose goods");
        int count = Helper.random(1, 4);
        for (int i = 0; i < count; i++) {
            Helper.sleep(Helper.random(ControlCentre.BUYER_CHOOSE_TIME_MIN, ControlCentre.BUYER_CHOOSE_TIME_MAX));
            putGoodsToBasket();
        }
        System.out.println(this.getName() + " finished to choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this.getName() + " go to queue");
        Queue.addBuyer(this);
        this.isRunnable = false;
        synchronized (this) {
            while (!this.isRunnable) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " go out");
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " take basket");
        basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        Good good = Good.getRandomGood();
        System.out.println(this.getName() + " put " + good);
        basket.put(good);
    }
}