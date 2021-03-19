package by.it.leshchenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String, Integer> map = new HashMap<>() {
        private static final long serialVersionUID = -1589178250133784261L;
        {
            this.put("=", 0);
            this.put("-", 1);
            this.put("+", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    public Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll("\\s+", "");

        final List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        final Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            final Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

        private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String operation = operations.get(i);
            if (priority < map.get(operation)) {
                index = i;
                priority = map.get(operation);
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = Var.createVar(rightStr);
        if (operation.contains("=")) {
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
        throw new CalcException("ERROR");
    }
}