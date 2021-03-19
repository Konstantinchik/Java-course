package by.it.evstratov.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();

        for (Method method : methods) {
            StringBuilder text = new StringBuilder();
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)){
                text.append("public ");
                if(Modifier.isStatic(modifiers)){
                    text.append("static ");
                }
                Class<?> returnType = method.getReturnType();
                String simpleName = returnType.getSimpleName();
                text.append(simpleName).append(" ");
                text.append(method.getName()).append("(");
                Parameter[] parameters = method.getParameters();
                String del = "";
                for (Parameter parameter : parameters) {
                    text.append(del).append(parameter.getType().getSimpleName());
                    del = ",";
                }
                text.append(")");
                System.out.println(text);
            }
        }

        for (Field field : fields) {
            StringBuilder text = new StringBuilder();
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers)){
                text.append("public ");
                if(Modifier.isStatic(modifiers)){
                    text.append("static ");
                }
                if(Modifier.isFinal(modifiers)){
                    text.append("final ");
                }
                Class<?> type = field.getType();
                text.append(type).append(" ");
                String name = field.getName();
                text.append(name);
                System.out.println(text);
            }
        }

    }

}
