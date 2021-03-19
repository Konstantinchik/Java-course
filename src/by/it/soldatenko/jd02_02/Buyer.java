package by.it.soldatenko.jd02_02;


import java.util.HashMap;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isRunnable;

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Buyer(int number) {
        super("Buyer №" + number + " ");
        Dispetcher.addBuyer();

    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispetcher.completeBuyer();
    }

    static boolean pensioneer() {

        int pens = Helper.getRandom(1, 4);
        boolean pensioneer = false;
        if (pens == 1) {
            pensioneer = true;
        }
        return pensioneer;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + "entered to Market");
    }

    @Override
    public void chooseGoods() {
        double speed = 1;
        if (pensioneer()) {
            speed = 1.5;
        }
        System.out.println(this + " started to choose goods");
//        int goodsAmount = Helper.getRandom(1, 4);
//        for (int i = 1; i <= goodsAmount; i++) {
//            Helper.sleep((int) speed * Helper.getRandom(500, 2000));
//
//            putGoodsToBasket();
//
//        }
        System.out.println(this + " finishded to choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " added to Queue");
        synchronized (this) {
            QueueBuyers.add(this);
            this.setRunnable(false);
            while (!this.isRunnable)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(this + " left the Queue");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " taked the Basket");

    }

    @Override
    public void putGoodsToBasket() {

    }


    @Override
    public void goOut() {
        System.out.println(this + " leaved the Market");
    }
}
