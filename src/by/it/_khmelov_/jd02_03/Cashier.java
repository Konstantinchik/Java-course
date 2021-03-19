package by.it._khmelov_.jd02_03;

class Cashier implements Runnable {

    private final int number;

    private final QueueBuyers queueBuyers;

    public Cashier(int number, QueueBuyers queueBuyers) {
        this.number = number;
        this.queueBuyers=queueBuyers;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = queueBuyers.extract();
            //noinspection DuplicatedCode
            if (buyer != null) {
                System.out.println(this + "started service for " + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.println(this + "finished service for " + buyer);
                //вообще монитор это buyer - я сделал метод просто, чтобы убрать warning
                synchronized (buyer.getMonitor()) {
                    buyer.setRunnable(true);
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
        return "\tCashier №" + number + " ";
    }
}
