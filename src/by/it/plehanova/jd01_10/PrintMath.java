package by.it.plehanova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("public ");
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }

            Class<?> returnType = method.getReturnType();
            String nameReturnType = returnType.getSimpleName();

            contract.append(nameReturnType).append(" ").append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            String delimiter = "";
            for (Parameter parameter : parameters) {
                contract.append(delimiter).append(parameter.getType().getSimpleName());
                delimiter = ",";
            }
            contract.append(")");
            System.out.println(contract);
        }

        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field field : declaredFields) {
            StringBuilder textField = new StringBuilder();
            int modifiers = field.getModifiers();

            if(Modifier.isPublic(modifiers)){
                textField.append(field.getType()).append(" ").append(field.getName());
            }
            System.out.println(textField);
        }

    }
}
