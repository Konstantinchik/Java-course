package by.it.arekhava.calc;

import by.it.arekhava.calc.Var;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
    public void print(CalcException e) {

            System.out.println(e.getMessage());

    }

    public void printErr(CalcException e) {
    }
}
