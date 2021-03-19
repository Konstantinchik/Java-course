package by.it.kglushchenko.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Basket basket;

    private boolean IsPensioneer = false;

    public Buyer(int number) {
        super("Buyer №" + number);
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        takeBasket();
        putGoodsToBasket();
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
        int k=1;
        if (buyerIsPensioneer()){
            k = Helper.getRandom(1,2); // коэффициент пенсионера, в среднем 1,5
        }
        Helper.sleepRandom(500*k, 2000*k); // выбирает товар
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the Market");
    }

    @Override
    public boolean buyerIsPensioneer() {
        return this.IsPensioneer;
    }

    @Override
    public void setPensioneerState(boolean state) {
        this.IsPensioneer = state;
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " takes a basket");
        basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        int thisBuyerGoodsCount = Helper.getRandom(1, 4); // покупатель выбирает от 1 до 4 товаров
        for (int i = 0; i < thisBuyerGoodsCount; i++) {
            int itemIndex = Helper.getRandom(0, Market.goods.size() - 1);
            Good item = Market.goods.get(itemIndex);

            int k=1;
            if (buyerIsPensioneer()){
                k = Helper.getRandom(1,2); // коэффициент пенсионера, в среднем 1,5
            }
            Helper.sleepRandom(500*k, 2000*k); // берет товар

            basket.add(item, 1);

            System.out.println(this + " has put " + item.getName() + " into the basket");
        }
        System.out.println(this + " has finished putting goods into the basket");
    }
}
