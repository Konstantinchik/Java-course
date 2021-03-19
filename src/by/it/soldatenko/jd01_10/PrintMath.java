package by.it.soldatenko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> aClass = Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                String contract = "public static " +
                        field.getType() + " " + field.getName() + "(" +
                        ")";
                System.out.println(contract);
            }
        }

        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                StringBuilder contract = new StringBuilder();
                contract.append("public static ");
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
        }

    }
}