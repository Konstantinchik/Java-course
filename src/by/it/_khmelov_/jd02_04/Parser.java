package by.it._khmelov_.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };


    public Var calc(String expression) throws CalcException {
        //A=2+2*2-9
        expression = expression.replaceAll("\\s+", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
            //вот тут если вектор с пробелами (а он с пробелами) то createVar не сработает
            //исправил в Var.createVar
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int prior = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String operation = operations.get(i);
            if (prior < priorityMap.get(operation)) {
                index = i;
                prior = priorityMap.get(operation);
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = Var.createVar(rightStr);
        if (operation.equals("=")) {
            return Var.save(leftStr, right);
        }
        Var left = Var.createVar(leftStr);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("err");
    }
}

