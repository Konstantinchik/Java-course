package by.it.kglushchenko.calc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) throws CalcException {
        // 3 + 4
        // 7
        expression = expression.replaceAll("\\s+", ""); // заменяем группу пробелов одним
        String[] part = expression.split(Patterns.OPERATION, 2); //


        if(part.length < 2){
            return Var.createVar(expression);
        }

        // A=9
        Var right = Var.createVar(part[1]);
        if(expression.contains("=")){
            // в операнде 0 содержится имя переменной
            return Var.saveVar(part[0],right); // ключ - операнд 0, значение - значение правой части
        }
        Var left = Var.createVar(part[0]);
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
