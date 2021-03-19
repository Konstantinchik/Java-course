package by.it._khmelov_.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> variables = new HashMap<>();

    public static Var save(String varName, Var varValue) {
        variables.put(varName, varValue);
        RepoVar.saveVariables(variables);
        return varValue;
    }


    public static Var createVar(String strVar) throws CalcException {
        //добавил для надежности парсинга строки
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (variables.containsKey(strVar)) {
            return variables.get(strVar);
        }
        throw new CalcException("Var " + strVar + " not found"); // exception
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s not found\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s not found\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s not found\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s not found\n", this, other));
    }

    @Override
    public String toString() {
        return "some abstract Var{}";
    }
}
