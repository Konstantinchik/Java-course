package by.it.terentyev.jd02_01;

import java.util.Random;

class Buyer extends Thread implements IBuyer, IUseBasket{
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
         Dispatcher.buyersINMarket--;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+ " started to choose goods");
        int timeout = Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+ " finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take basket");
    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(Basket.putToBasket(Helper.random.nextInt(3)));

    }
}
