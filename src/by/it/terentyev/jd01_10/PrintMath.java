package by.it.terentyev.jd01_10;

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
            if (Modifier.isPublic(modifiers)){
                contract.append("public");
            }
            if (Modifier.isStatic(modifiers)){
                contract.append("static");
            }
            Class<?> returnType = method.getReturnType();
            String nameReturnType = returnType.getSimpleName();
            contract.append(nameReturnType).append(" ");
            contract.append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            String delimeter = "";

        }

    }
}
