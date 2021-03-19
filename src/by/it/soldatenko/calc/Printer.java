package by.it.soldatenko.calc;

public class Printer {
    void print(Var var){
       if (var!=null)
           System.out.println(var);
    }
    void print(CalcException e){
        System.out.println(e.getMessage());

    }
}
