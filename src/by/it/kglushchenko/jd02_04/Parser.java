package by.it.kglushchenko.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    // нужно понять какая операция самая приоритетная
    // String - операция, Integer - приоритет
    private static final Map<String, Integer> priorityMap = new HashMap<>() {
        {   // создадим логический блок
            // операция , приоритет
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };  // здесь надо  ;

    public Var calc(String expression) throws CalcException {
        // A=2+2*2-9   - расчетное выражение
        //final String[] split = expression.split(Patterns.OPERATION);
        expression = expression.replaceAll("\\s+", ""); // заменяем группу пробелов одним
        // мы сделаем List
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        // Matcher при каждом поиске будет находть следующую операцию
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        // Создаем List для operations
        List<String> operations = new ArrayList<>();
        // обходим matcher
        while (matcher.find()) {
            // пока matcher что-то находит мы это складываем в наш List operations
            operations.add(matcher.group()); // группа без захвата, ПОЭТОМУ ИСПОЛЬЗУЕМ ТОЛЬКО ДЛЯ operations
        }
        while (operations.size() > 0) {
            // нужно определить какая операция самая приоритетная
            int index = getIndex(operations);
            String left = operands.remove(index);  // левая двойка    A=2+[2]*2-9
            String right = operands.remove(index); // правая двойка   A=2+2*[2]-9
            String operation = operations.remove(index);   // сама операция между ними, что лежит в массиве
            Var result = calcOneOperation(left, operation, right);
            // вектор с пробелами, требуется исправление в Var.createVar
            operands.add(index, result.toString());
            // когда подсчеты закончатся результат будет лежать в нулевой позиции списка operands
        }
        return Var.createVar(operands.get(0));
    }


    private int getIndex(List<String> operations) {
        int index = -1; // текущий индекс
        int prior = -1; // текущий приоритет
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {  // проверяем у кого приоритет выше
            String operation = operations.get(i);
            if (prior < priorityMap.get(operation)) {   // если мой текущий приоритет меньше чем приоритет в таблице по ключу operation
                // найдена более приоритетная операция чем текущая
                index = i;
                prior = priorityMap.get(operation); // обновляем текущий приоритет
            }
        }
        return index; // возвращается номер самой приоритетной операции
    }

    //private Var calcOneOperation(String expression) throws CalcException { - old
    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        // 3 + 4
        // 7
        //expression = expression.replaceAll("\\s+", ""); // заменяем группу пробелов одним - перенесли в Var calc

        //  length  гарантированно 2 операции
        //String[] part = expression.split(Patterns.OPERATION, 2); // 2 значения
        //if(part.length < 2){
        //    return Var.createVar(expression);
        //}

        // A=9
        //Var right = Var.createVar(part[1]);
        //  правая часть будет сделана из rightStr
        Var right = Var.createVar(rightStr);
        //if(expression.contains("=")){
        if (operation.equals("=")) {
            // в операнде 0 содержится имя переменной
            //return Var.saveVar(part[0],right); // ключ - операнд 0, значение - значение правой части  - OLD
            return Var.saveVar(leftStr, right);
        }
        //Var left = Var.createVar(part[0]);    - OLD
        Var left = Var.createVar(leftStr);
        //if (Objects.nonNull(left) && Objects.nonNull(right)) {    объекты на null можно не проверять потому что .createVar проверяет
        //Pattern compile = Pattern.compile(Patterns.OPERATION);
        //Matcher matcher = compile.matcher(expression);
        //if (matcher.find()) {             компилировать и искать операцию не нужно. операция известна
        //String operation = matcher.group();
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
        //}
        //}
        //return null; по легике программы мы не должны сюда прийти
        throw new CalcException("Impossible Exception");
    }
}
