package by.it.rydzeuski.jd02_03;


class Buyer extends Thread implements IBueyr {


    private boolean isRunnable;
    private final QueueBuyers queueBuyers;

    public void setisRunnable(boolean isRunnable) {
        this.isRunnable = isRunnable;
    }

    public Buyer(int number, QueueBuyers queueBuyers) {
        super("Bueyr №" + number);
        this.queueBuyers = queueBuyers;
        Dispatcher.addBueyr();
    }

    @Override
    public void run() {

        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBueyr();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "  started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + "  finished choose goods");
    }

    @Override
    public void goToQueue() {
        queueBuyers.add(this);
        System.out.println(this + " added to Queue");
        this.setisRunnable(false);
        synchronized (this) {
            while (!this.isRunnable)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this + " left the Queue");

    }

    @Override
    public void goOut() {
        System.out.println(this + " left the market");

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
