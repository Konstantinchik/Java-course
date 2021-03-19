package by.it.plehanova.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String, Integer> prioryOperation = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 2);
            this.put("*", 3);
            this.put("/", 4);
        }
    };

    public Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll("\\s+", "");
        expression = calcInBrackets(expression);
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        ArrayList<String> operations = new ArrayList<>();
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String operation = operations.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priority < prioryOperation.get(operation)) {
                index = i;
                priority = prioryOperation.get(operation);
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
                RepoVar.saveConsoleOut(left + "+" + right + "=" + left.add(right));
                return left.add(right);
            case "-":
                RepoVar.saveConsoleOut(left + "-" + right + "=" + left.sub(right));
                return left.sub(right);
            case "*":
                RepoVar.saveConsoleOut(left + "*" + right + "=" + left.mul(right));
                return left.mul(right);
            case "/":
                RepoVar.saveConsoleOut(left + "/" + right + "=" + left.div(right));
                return left.div(right);
        }
        throw new CalcException(ConsoleRunner.lang.get(Error.ERROR));
    }

    private String calcInBrackets(String expression) throws CalcException {
        if (expression.contains("(")) {
            Pattern patterns = Pattern.compile(Patterns.BRACKETS);
            Matcher matcher = patterns.matcher(expression);
            while (matcher.find()) {
                String expressionInBrackets = matcher.group();
                Var result = calc(expressionInBrackets.replaceAll("[\\(\\)]", ""));
                expression = expression.replace(expressionInBrackets, result.toString());
            }
            expression=calcInBrackets(expression);
        }
        return expression;
    }
}

