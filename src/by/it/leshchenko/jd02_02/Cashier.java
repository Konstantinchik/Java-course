package by.it.leshchenko.jd02_02;

public class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cashier #" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " open");

        while (!Market.isClosed()) {
            Buyer buyer = Queue.leftBuyer();
            if (buyer != null) {
                System.out.println(this + " start service " + buyer.getName());
                System.out.println(buyer.getName() + " leave from queue");
                Helper.sleep(Helper.random(2000, 5000));
                synchronized (buyer) {
                    System.out.println(this + " finish service " + buyer.getName());
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            } else {
                Helper.sleep(1); // TODO Need to fix
            }
        }

        System.out.println(this + " close");
    }
}
