package by.it._khmelov_.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> aClass = Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }
            Class<?> returnType = method.getReturnType();
            String nameReturnType = returnType.getSimpleName();
            contract.append(nameReturnType).append(" ");
            contract.append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            String delimiter = "";
            for (Parameter parameter : parameters) {
                contract.append(delimiter).append(parameter.getType().getSimpleName());
                delimiter = ",";
            }
            contract.append(")");
            System.out.println(contract);
            //(modifiers & 8) == 8)
            //000000000000000001001 //9
            //000000000000000001000 //8
            //&&&&&&&&&&&&&&&&&&&&&
            //000000000000000001000 //
        }
    }
}
