package by.it._khmelov_.jd01_10;

public class Bean {

    @Param(a = 2, b = 5)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 2, b = 5)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    @Param(a = 2, b = 5)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    static double min(int a, int b) {
        return Math.min(a, b);
    }

}
