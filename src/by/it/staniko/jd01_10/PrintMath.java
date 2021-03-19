package by.it.staniko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.sql.SQLOutput;

public class  PrintMath {
    public static void main(String[] args) {
        Class<?> aClass = Math.class;
        Method[] methods=aClass.getDeclaredMethods();
        for (Method method:methods){
            StringBuilder out = new StringBuilder();
            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
            }
            if (Modifier.isStatic(modifiers)) {
                out.append("static ");
            }
                //if ((modifiers&8)==8){
            Class<?> retutnType=method.getReturnType();
            String nameReturnType= retutnType.getSimpleName();
            out.append(nameReturnType).append(" ");
            out.append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            String delimiter=" ";
            for (Parameter parameter:parameters){
                out.append(delimiter).append(parameter.getType().getSimpleName());
                delimiter=",";
            }
            out.append(")");
            System.out.println(out);
        }
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder textField = new StringBuilder();
            int modifiers = field.getModifiers();

            if(Modifier.isPublic(modifiers)){
                textField.append(field.getType()).append(" ").append(field.getName());
            }
            System.out.println(textField);
        }

    }

}
