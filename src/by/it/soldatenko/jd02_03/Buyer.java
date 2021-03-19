package by.it.soldatenko.jd02_03;


import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private final QueueBuyers queueBuyers;
    private boolean isRunnable;
    private static final Semaphore semaphore = new Semaphore(20);

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Buyer(int number, QueueBuyers queueBuyers) {
        super("Buyer №" + number + " ");
        this.queueBuyers = queueBuyers;
        Dispetcher.addBuyer();

    }

    @Override
    public void run() {
        enterToMarket();

        takeBasket();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chooseGoods();
        semaphore.release();
        goToQueue();
        goOut();
        Dispetcher.completeBuyer();
    }

    static boolean pensioner() {

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
        if (pensioner()) {
            speed = 1.5;
        }
        System.out.println(this + " started to choose goods");

        Helper.sleep((int) speed * Helper.getRandom(500, 2000));
//

        System.out.println(this + " finishded to choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " added to Queue");
        synchronized (this) {
            queueBuyers.add(this);
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
//        System.out.println(this + " puted " + Good.getGood()[0] + " to the Basket");

    }


    @Override
    public void goOut() {
        System.out.println(this + " leaved the Market");
    }
}
