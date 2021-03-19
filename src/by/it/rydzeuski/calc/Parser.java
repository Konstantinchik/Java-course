package by.it.rydzeuski.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 class Parser {

     Var calc(String expression) throws CalcException  {
        expression = expression.trim().replaceAll("\\s+", "");
        String[] part = expression.split(Patterns.OPERATION);
        Var right = Var.createVar(part[1]);
        if (expression.contains("=")) {
            return Var.saveVar(part[0],right );
        }
        Var left = Var.createVar(part[0]);

        if (left != null && right != null) {
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
