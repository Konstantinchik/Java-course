package by.it.rydzeuski.jd02_01;

class Buyer extends Thread implements IBueyr {

    public Buyer(int number) {
        super("Bueyr №" + number);
    }

    @Override
    public void run() {
       enterToMarket();
       chooseGoods();
       goOut();
    }

    @Override
    public String toString() {
        return this.getName();
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
    public void goOut() {
        System.out.println(this + " left the market");

    }
}
