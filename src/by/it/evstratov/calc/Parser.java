package by.it.evstratov.calc;

import by.it.evstratov.calc.language.ErrorLang;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static boolean checkBrackets(String expression){

        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        Map<Character, Integer> openBrackets = new HashMap<>();
        Map<Character, Integer> closeBrackets = new HashMap<>();

        char[] chars = expression.toCharArray();

        openBrackets.put('{',0);
        openBrackets.put('(',1);
        openBrackets.put('[',2);

        closeBrackets.put('}',0);
        closeBrackets.put(')',1);
        closeBrackets.put(']',2);

        for (int i = 0; i < chars.length; i++) {
            if(openBrackets.containsKey(chars[i])){
                arrayDeque.add(chars[i]);
            }else if(closeBrackets.containsKey(chars[i]) && !arrayDeque.isEmpty()){
                if(openBrackets.get(arrayDeque.getLast()).equals(closeBrackets.get(chars[i]))){
                    arrayDeque.removeLast();
                }
            }else{
                return false;
            }
        }
        return arrayDeque.isEmpty();
    }

    private static final Map<String, Integer> priorityMap = new HashMap<String, Integer>(){
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private static String calcWithBrackets(String ex) throws CalcException {
        String reg = "[^()]+";
        Parser parser = new Parser();
        if(!ex.replaceAll(reg,"").equals("") && checkBrackets(ex.replaceAll(reg,""))){
            Matcher matcher = Pattern.compile("\\([^()]+\\)").matcher(ex.replace(" ",""));
            while (matcher.find()){
                String line = matcher.group().substring(1,matcher.group().length()-1);
                Var var = parser.calc(line);
                String replace = ex.replace(matcher.group(), var.toString());
                ex = replace;
                ex = calcWithBrackets(ex);
            }
        }
        return ex;
    }

    public Var calc(String ex) throws CalcException{
        ex = calcWithBrackets(ex);
        ex = ex.replaceAll("\\s","");
        List<String> operands = new ArrayList<>(Arrays.asList(ex.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(ex.replace(" ",""));
        List<String> operations = new ArrayList<>();
        while (matcher.find()){
            operations.add(matcher.group());
        }
        while (operations.size() > 0){
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
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

    public Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = Var.createVar(rightStr);
        if(operation.equals("=")){
            return Var.saveVar(leftStr, right);
        }
        Var left = Var.createVar(leftStr);

        switch (operation){
            case "+" :
                RepoVar.saveToLog(right + " + " + left +" = "+right.addWidth(left));
                return right.addWidth(left);
            case "-" : RepoVar.saveToLog(right + " - " + left+" = "+right.subWidth(left));
                return right.subWidth(left);
            case "*" : RepoVar.saveToLog(right + " * " + left+" = "+right.mulWidth(left));
                return right.mulWidth(left);
            case "/" : RepoVar.saveToLog(right + " / " + left+" = "+right.divWidth(left));
                return right.divWidth(left);
        }
        throw new CalcException(ConsoleRunner.lang.get(ErrorLang.ERROR));
    }
}
