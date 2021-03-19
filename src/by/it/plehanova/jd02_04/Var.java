package by.it.plehanova.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static final Map<String, Var> variables = new HashMap<>();

    public static Var save(String varName, Var varValue) {
        variables.put(varName, varValue);
        RepoVar.saveVariables(variables);
        return varValue;
    }
    public static void printVar(){
        for(Map.Entry<String, Var> entry: variables.entrySet()){
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }
    public static void sortVar(){
        TreeMap<String, Var> sort = new TreeMap<>(variables);
        for(Map.Entry<String, Var> entry: sort.entrySet()){
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }

    public static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (variables.containsKey(operand)) {
            return variables.get(operand);
        }
        throw new CalcException("Var " + operand + " not found");
    }

    @Override
    public Var add(Var other) throws CalcException {
       throw  new CalcException(String.format("Operation %s + %s not found\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw  new CalcException(String.format("Operation %s + %s not found\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw  new CalcException(String.format("Operation %s + %s not found\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw  new CalcException(String.format("Operation %s + %s not found\n", this, other));
    }

    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }
}
