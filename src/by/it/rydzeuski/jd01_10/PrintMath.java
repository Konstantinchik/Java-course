package by.it.rydzeuski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> aClass=Math.class;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method:methods){
        StringBuilder out =new StringBuilder();
          int modifiers=  method.getModifiers();
          if (Modifier.isPublic(modifiers)){
              out.append("public");
          }
          if (Modifier.isStatic(modifiers)){
              out.append("static");
          }




        }

    }
}
