package by.it._khmelov_.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        //2 + 3;
        //7
        expression = expression.replaceAll("\\s+", "");
        String[] part = expression.split(Patterns.OPERATION, 2);
        if (part.length < 2) {
            return Var.createVar(expression);
        }
        Var left = Var.createVar(part[0]);
        Var right = Var.createVar(part[1]);
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            Pattern compile = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = compile.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
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
            }
        }
        return null;
    }
}
