package by.it.leshchenko.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    Basket basket;

    public Buyer(int i) {
        super("Buyer #" + i);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.getName() + " started to choose goods");
        int count = Helper.random(1,4);
        for (int i = 0; i < count; i++) {
            Helper.sleep(Helper.random(ControlCentre.BUYER_CHOOSE_TIME_MIN, ControlCentre.BUYER_CHOOSE_TIME_MAX));
            putGoodsToBasket();
        }
        System.out.println(this.getName() + " finished to choose goods");
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