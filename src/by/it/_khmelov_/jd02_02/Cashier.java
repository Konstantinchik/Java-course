package by.it._khmelov_.jd02_02;

class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
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
