package by.it.plehanova.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        expression = expression.trim().replaceAll("\\s+", "");
        String[] line = expression.split(Patterns.OPERATION);

        if (line.length < 2) {
            return Var.createVar(expression);
        }
        Var[] operand = new Var[line.length];
        for (int i = 0; i < operand.length; i++) {
            operand[i] = Var.createVar(line[i]);
        }

        if (Objects.nonNull(operand[0]) && Objects.nonNull(operand[1])) {
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher match = pattern.matcher(expression);

            while (match.find()) {
                String operation = match.group();

                switch (operation) {
                    case "+":
                        return operand[0].add(operand[1]);

                    case "-":
                        return operand[0].sub(operand[1]);

                    case "*":
                        return operand[0].mul(operand[1]);

                    case "/":
                        return operand[0].div(operand[1]);

                }
            }
        }
        return null;
    }
}
