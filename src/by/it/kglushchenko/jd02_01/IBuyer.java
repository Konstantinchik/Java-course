package by.it.kglushchenko.jd02_01;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void goOut();//отправился на выход(мгновенно)

    boolean buyerIsPensioneer(); // полупатель пенсионер?

    void setPensioneerState(boolean state); // установить статус пенсионности
}