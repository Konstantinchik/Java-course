package by.it.novik.jd01_10;

public class Bean {
    public static void main(String[] args) {

    }


@Param(a=4,b=6)
    public static double sum (int a, int b){
        double res1= a+b;
    return res1;
    }
    @Param(a=2,b=3)
    public static double max (int a, int b){
        if (a<b) { return b; }
        else { return a; }
    }
    @Param(a=1,b=2)
    public double min (int a, int b){
        if (a>b) { return b; }
        else { return a; }
    }

    public double avg (int a, int b){
        double res2=(a+b)/2.0;
        return res2;
    }





}


