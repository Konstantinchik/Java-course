package by.it.evstratov.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBasket{

    private Basket basket;
    private boolean isPensioneer;

    public Buyer(int number){
        super("Buyer №"+number);
    }

    @Override
    public String toString() {
        return this.getName();
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
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        double timeOut = Helper.getRandom(500,2000);
        if(isPensioneer){
            timeOut *= 1.5;
        }
        putGoodsToBasket();
        Helper.sleep((int)timeOut/Dispatcher.K_SPEED);
        System.out.println(this + " finish choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left to market");
        Dispatcher.buyersInMarket--;
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
        this.basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 1; i <= Helper.getRandom(1,4); i++) {
            double timeOut = Helper.getRandom(500,2000);
            if(isPensioneer){
                timeOut *= 1.5;
            }
            Helper.sleep((int)timeOut/Dispatcher.K_SPEED);
            Good good = Good.takeRandomGood();
            System.out.println(this + " put in basket "+good.toString());
            this.basket.put(good);
        }
    }

    public void setPensioneer(boolean pensioneer) {
        isPensioneer = pensioneer;
    }

    public boolean isPensioneer() {
        return isPensioneer;
    }
}
