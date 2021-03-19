package by.it.evstratov.jd02_02;

import java.util.List;

public class Cashier implements Runnable{

    private final int number;
    private volatile static int openCashiers = 0;
    static final Object lock = new Object();

    public Cashier(int number) {
        this.number = number;
        addCashier();
    }

    private static void addCashier(){
        synchronized (Cashier.class){
            openCashiers++;
        }
    }

    @Override
    public void run() {
        System.out.println(this + "opened");

        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = QueueBuyers.extract();
            if(buyer != null){
                int t = Helper.getRandom(2000,5000);
                Helper.sleep(t);
                printCheck(this,buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                synchronized (this){
                    if(openCashiers == 1){
                        System.out.println(this + "в ожидании покупателей (единственная открытая касса)");
                        try {
                            if(Dispatcher.marketIsOpened()){
                                Cashier.lock.wait();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        openCashiers--;
                        Dispatcher.clearNumberForCashier(number);
                        System.out.println(this + "закрывается. Осталось открытых касс - "+openCashiers);
                        break;
                    }
                }
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";
    }

    public static int getOpenCashiers() {
        synchronized (Cashier.class){
            return openCashiers;
        }
    }

    public int getNumber() {
        return number;
    }

    public static void printCheck(Cashier cashier, Buyer buyer){
        synchronized (Cashier.lock){
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 40; i++) {
                space.append(".");
            }
            StringBuilder spaceLeft = new StringBuilder();
            StringBuilder spaceRight = new StringBuilder();
            for (int i = 0; i < cashier.getNumber()-1; i++) {
                spaceLeft.append(space);
            }
            for (int i = 0; i < 5-cashier.getNumber()-1; i++) {
                spaceRight.append(space);
            }
            spaceRight.append(" ");

            StringBuilder result = new StringBuilder();
            result.append(spaceLeft).append(cashier).append("started service for ").append(buyer).append("\n");
            int sumCheck = 0;
            List<Good> allGoodsInBasket = buyer.getBasket().getGoods();
            for (Good good : allGoodsInBasket) {
                result.append(spaceLeft).append(good.toString()).append("\n");
                sumCheck += good.getPrice();
            }
            Dispatcher.addTotal(sumCheck);
            result.append(spaceLeft).append("Сумма чека для ").append(cashier).append(" = ").append(sumCheck).append("\n");
            result.append(spaceLeft).append(cashier).append("finished service for ").append(buyer).append(spaceRight).append(Dispatcher.getTotal()).append(" ").append(QueueBuyers.getSize()).append("\n");
            System.out.println(result);
        }
    }
}
