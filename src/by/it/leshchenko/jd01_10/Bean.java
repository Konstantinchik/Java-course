package by.it.leshchenko.jd01_10;

public class Bean {
    @Param(a = 1, b = 2)
    static double sum(int a, int b) {
        return a + b;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    @Param(a = 3, b = 4)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 5, b = 6)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    static double avg(int a, int b) {
        return (double) (a + b) / 2;
    }
}
