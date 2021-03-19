package by.it.rydzeuski.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        RepoVar.saveToFile(vars);
        return var;
    }

     static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);

        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);

        } else {
            throw  new CalcException("Var"+strVar+"not found");
        }


    }

    @Override
    public Var add(Var other)throws CalcException {
        throw new CalcException("Операция сложения" + this + "+" + other + "невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычетания" + this + "-" + other + "невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения" + this + "*" + other + "невозможна");

    }

    @Override
    public Var div(Var other)throws CalcException {
        throw new CalcException("Операция деления" + this + "/" + other + "невозможна");

    }
}
