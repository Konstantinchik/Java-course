package by.it.kglushchenko.jd02_03;


public class Cashier implements Runnable {

    private final int number;

    private final QueueBuyers queueBuyers;

    public Cashier(int number, QueueBuyers queueBuyers) {
        this.number = number;
        this.queueBuyers = queueBuyers;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        // do smth
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
                    buyer.setProcessedByCashier(true);
                    buyer.notify();
                }
            } else {
                //PCP
                Helper.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Cashier #" + number + " ";
    }
}
