package by.it.evstratov.jd_02_03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QueueCashiers {

    private static final List<Cashier> openCashiers = new CopyOnWriteArrayList<>();

    public static List<Cashier> getAllCashiers() {
        return openCashiers;
    }

}
