package by.it.staniko.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {

        //2*2
        expression=expression.replaceAll("\\s+","");
        String[] part= expression.split(Patterns.OPERATION,2);
        if (part.length<2){
            return Var.createVar(expression);
        }
        Var left = Var.createVar(part[0]);
        Var right = Var.createVar(part[1]);
        if (left != null || right!=null){
            Pattern compile = Pattern.compile(Patterns.OPERATION);
            Matcher matcher=compile.matcher(expression);
            if (matcher.find()){
                String operation= matcher.group();
                switch(operation){
                    case "+" :return left.add(right);
                    case "-" :return left.sub(right);
                    case "*" :return left.mul(right);
                    case "/" :return left.div(right);
                }
            }
        }

            return null;
    }
}
