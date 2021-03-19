package by.it.kglushchenko.jd01_10;

public class Bean {
    @Param(a=2,b=5)
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=3,b=4)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }

    @SuppressWarnings("ManualMinMaxCalculator")
    //@Param(a=1,b=2)
    static double min(int a, int b){
        return a<b? a: b;
    }

    @SuppressWarnings("ManualMinMaxCalculator")
    @Param(a=1,b=2)
    double max(int a, int b){
        return a>b? a: b;
    }
}
