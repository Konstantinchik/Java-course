package by.it.kglushchenko.jd02_02;

public interface IBuyer {
    // покупатели становятся все в одну очетедь

    void enterToMarket(); // вошел в магазин (мгновенно)

    void chooseGoods();   // выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();     // Покупатель отправляется в очередь

    void goOut();         // отправился на выход (мгновенно)

    boolean isPensioner(); // полупатель пенсионер?
}
