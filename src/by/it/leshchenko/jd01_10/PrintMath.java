package by.it.leshchenko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            StringBuilder sb = new StringBuilder();
            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                sb.append("public ");

                if (Modifier.isStatic(modifiers)) {
                    sb.append("static ");
                }
                String type = method.getReturnType().getSimpleName();
                sb.append(type).append(" ");
                sb.append(method.getName());
                sb.append("(");
                Parameter[] parameters = method.getParameters();
                String delimeter = "";
                for (Parameter parameter : parameters) {
                    sb.append(delimeter).append(parameter.getType());
                    delimeter = ",";
                }
                sb.append(")");

                System.out.println(sb);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            int fieldModifiers = field.getModifiers();
            if (Modifier.isPublic(fieldModifiers)) {
                System.out.printf("%s %s\n", field.getType(), field.getName());
            }
        }
    }
}
