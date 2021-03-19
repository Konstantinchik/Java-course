package by.it.terentyev.jd01_10;

public class Bean {
    @Param(a=2,b=5)
    double sum (int a, int b) {
        return (a+b);
    }

    static double avg (int a, int b) {
        return (a+b)/2.0;
    }
    double max (int a, int b) {
        return a>b ?a:b;
    }
    double min (int a, int b) {
        return (a+b);
    }
}
