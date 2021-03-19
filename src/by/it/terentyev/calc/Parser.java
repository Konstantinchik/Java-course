package by.it.terentyev.calc;

public class Parser {
    public Var calc(String expression) {
        expression = expression.replaceAll("\\s+","");
        String[] part = expression.split(Patterns.OPERATION, 2);
//        if (part.length<2){
//            return Var.createVar(expression);
//        }




        return null;
    }
}
