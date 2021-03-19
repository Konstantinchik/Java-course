package by.it.kglushchenko.jd02_02;

public class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {

        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            final Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service for " + buyer);

                Helper.sleepRandom(2000, 5000);

                System.out.println(this + "finished service for " + buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setProcessedByCashier(true);
                    buyer.notify();
                }
            } else {
                //PCP
                Helper.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "Cashier #" + number + " ";
    }
}
