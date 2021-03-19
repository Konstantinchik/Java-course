package by.it.plehanova.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = new Basket();
    private boolean pensioner;

    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.enter();
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
        Dispatcher.goOut();
    }

    @Override
    public void enterToMarket() {
        if (this.isPensioner()) {
            System.out.println(this + " is pensioner entered to Market");
        } else {
            System.out.println(this + " entered to Market");
        }
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
    public void goOut() {
        System.out.println(this + " leaves the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        Good good = ListGoods.randomGood();
        basket.putGoods(good);
        System.out.println(this + " put a good in the basket " + good);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
