package by.it.arekhava.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.sql.SQLOutput;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> aClass = Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods){
            StringBuilder out=new StringBuilder();

            int modifiers=method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                out.append("static ");
            }
            Class<?> returnType = method.getReturnType();
            String nameRetuType = returnType.getSimpleName();
            out.append(nameRetuType).append(" ");
            out.append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            String delimiter=",";
            for (Parameter parameter:parameters) {
                out.append(delimiter).append(parameter.getType().getSimpleName());
            }
              out.append(")");
            System.out.println(out);
            }

        }

}
