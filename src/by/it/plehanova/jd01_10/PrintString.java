package by.it.plehanova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            String nameMethod;
            int modifiers = method.getModifiers();

            if(!(Modifier.isStatic(modifiers))){
                nameMethod = method.getName();
                System.out.println(nameMethod);
            }
        }
    }
}
