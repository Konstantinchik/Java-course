package by.it.soldatenko.jd02_01;


import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {


    public Buyer(int number) {
        super("Buyer №" + number + " ");
    }

    static boolean pensioneer() {

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
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        Market.quantityIn++;
        System.out.println(this + "entered to Market");
    }

    @Override
    public void chooseGoods() {
        double speed=1;
        if (pensioneer()){
            speed = 1.5;
        }
        System.out.println(this + " started to choose goods");
        int goodsAmount = Helper.getRandom(1, 4);
        for (int i = 1; i <= goodsAmount; i++) {
            Helper.sleep((int) speed*Helper.getRandom(500, 2000));

            putGoodsToBasket();
        }
        System.out.println(this + " finishded to choose goods");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " taked the Basket");

    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " puted " + Good.getGood() + " to the Basket");

    }

    @Override
    public void goOut() {
        System.out.println(this + " leaved the Market");
        Market.quantityOut++;
    }
}
