package by.it._khmelov_.jd02_01;

class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
        //noinspection NonAtomicOperationOnVolatileField
        Dispatcher.buyersInMarket--;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the Market");
    }
}
