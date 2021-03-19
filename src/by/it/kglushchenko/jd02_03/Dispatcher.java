package by.it.kglushchenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    final static int K_SPEED = 100000;
    final static int PLAN = 100;

//    volatile static int buyersInMarket = 0; // сколько человек в магазине
//    volatile static int buyersCompleted = 0; // сколько человек в магазине
//    суммарное количество покупетелей посетивших магазин = в магазине + кто вышел
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersCompleted = new AtomicInteger(0);

    public static void reset() {
//        buyersCompleted = 0;
//        buyersInMarket = 0;
        buyersCompleted.set(0);
        buyersInMarket.set(0);
    }

    static void addBuyer() {
//        synchronized (Dispatcher.class) {
//            buyersInMarket++;
//        }
        buyersInMarket.getAndIncrement();
    }

//    static synchronized void completeBuyer() {
//        buyersInMarket--;                // в магазине его уже нет, вычелся из магазина
//        buyersCompleted++;               // количество завершенных покупателей инкрементируем
//    }
    static void completeBuyers(){
        buyersInMarket.getAndDecrement();
        buyersCompleted.getAndIncrement();
    }

    // как понять можно еще впускать покупателей или нет

    static boolean marketIsOpened(){
        // впускать в магазин я могу если количесто в магазине + вышедших из магазина < PLAN
        // переменные volatile, их нет в кэшах. можно без synchronized
        //return buyersInMarket + buyersCompleted <= PLAN; // first - < PLAN // 2nd - !=
        return buyersInMarket.get() + buyersCompleted.get() != PLAN;
    }

    // одно поле, одно действие, synchronized можно не делать
    // сэкономим 300 тактов синхронизации, будет 1 такт чтения
    static boolean marketIsClosed(){     // здесь можно не делать
        //return buyersCompleted == PLAN;
        return  buyersCompleted.get() == PLAN;
    }
}
