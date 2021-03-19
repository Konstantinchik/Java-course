package by.it.plehanova.jd02_02;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private final Basket basket = new Basket();
    private boolean isPensioner;
    private boolean isRunnable;

    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean isPensioner() {
        return isPensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.isPensioner = pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        if (this.isPensioner()) {
            System.out.println(this + " is pensioner entered to Market");
        } else {
            System.out.println(this + " entered to Market");
        };
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " Started choose goods");
        for (int i = 0; i < Helper.getRandom(1, 4); i++) {
            putGoodsToBasket();
            int timeout = Helper.getRandom(500, 2000);
            if (this.isPensioner()) {
                timeout = (int) (timeout * 1.5);
            }
            Helper.sleep(timeout);
        }
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goToQueue() {

        QueueBuyers.add(this);
        /*if (Dispatcher.needToOpenCashier() < Dispatcher.getOpenCashier()) {
            for (int i = 0; i < Dispatcher.needToOpenCashier() - Dispatcher.getOpenCashier(); i++) {
                if (Dispatcher.getOpenCashier() < Dispatcher.MAX_CASHIERS) {
                    Cashier cashier = ListCashiers.extract();
                    Thread cashierThread = new Thread(cashier);
                    ListCashiers.setCashiers(cashierThread);
                    cashierThread.start();
                }
            }
        }*/
        System.out.println(this + " add to queue");
        synchronized (Dispatcher.cashierMonitor) {
            if (Dispatcher.getOpenCashier() == 0) {
                Dispatcher.cashierMonitor.notify();
            }
        }
        this.setRunnable(false);
        synchronized (this) {
            while (!this.isRunnable) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + " left the queue");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the Market");
        Dispatcher.goOutBuyers();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");

    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put a good in the basket");
        basket.putGoods(ListGoods.randomGood());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
