package by.it.rydzeuski.jd02_03;

public class Cashier implements Runnable {
    private final int number;
    private final QueueBuyers queueBuyers;

    public Cashier(int number,QueueBuyers queueBuyers) {

        this.number = number;
        this.queueBuyers=queueBuyers;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = queueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service for" + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.println(this + "finished service for" + buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setisRunnable(true);
                    buyer.notify();
                }
            } else {
                Helper.sleep(1);
            }

        }
        System.out.println(this + "closed");

    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";

    }
}
