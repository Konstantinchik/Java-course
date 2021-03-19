package by.it.kglushchenko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import static java.lang.Math.*;

public class PrintMath {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> mClass = Math.class;
        Object obj = (Object)(Math.class);
        Method[] methods = mClass.getDeclaredMethods(); // whithout Object
        Field[] declaredFields = mClass.getDeclaredFields();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            //00000000000000000000000000001001 public static
            /*
            if((modifiers&8)==8){
                // static
                out.append("static ");
            }
            if((modifiers&1)==1){
                // public
                out.append("public ");
            }*/
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
            }
            if (Modifier.isPrivate(modifiers)) {
                out.append("private ");
            }
            if (Modifier.isProtected(modifiers)) {
                out.append("protected ");
            }
            if (Modifier.isStatic(modifiers)) {
                out.append("static ");
            }

            if (Modifier.isPublic(modifiers)) {
                // выводим только публичные методы

                // Тип метода
                Class<?> returnType = method.getReturnType();
                String nameReturnType = returnType.getSimpleName();
                out.append(nameReturnType).append(" ");
                // Имя метода c параметрами
                out.append(method.getName()).append("(");
                // Получим массив всех параметров
                Parameter[] parameters = method.getParameters();
                String delimeter = "";
                for (Parameter parameter : parameters) {
                    out.append(delimeter).append(parameter.getType().getSimpleName());
                    delimeter = ",";
                }
                out.append(")");

                System.out.println(out);
            } // Modifier.isPublic(modifiers)
        }

        // Fields
        for (Field field : declaredFields) {
            StringBuilder out = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                //out.append("public ");
                Class<?> type = field.getType();
                String name = field.getName();
                out.append(field.getType().getSimpleName()).append(" ").append(name).append("\n");
            }
            System.out.print(out);
        }
    }
}
