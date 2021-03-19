package by.it.novik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> strClass = String.class;
        Method[] meth = strClass.getDeclaredMethods();
        for (Method method : meth) {
            int mod = method.getModifiers();
            if (!Modifier.isStatic(mod)){
                System.out.println(method.getName());
            }
        }
    }
}
