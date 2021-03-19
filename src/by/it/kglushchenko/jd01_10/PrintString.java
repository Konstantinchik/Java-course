package by.it.kglushchenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args )throws ClassNotFoundException {
        /*Class<?> stringClass = String.class;
        for(Method method : stringClass.getDeclaredMethods()){
            String name = method.getName();
            Class<?>[] types = method.getParameterTypes();
            if(types) {
                //String returnType = method.getReturnType().getSimpleName();
                String returnType = method.getReturnType().getSimpleName();
                //System.out.println(returnType);
                //System.out.println(name);
                //System.out.println(name);
                //for(int i=0; i< types.length; i++) {
                //    System.out.println(types.toString());
                //}
            }
        }*/
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for(Method md : methods){
            int modifiers = md.getModifiers();
            StringBuilder out = new StringBuilder();
            if (!Modifier.isStatic(modifiers)) {
                // нам нужны нестатические методы
                Class<?> returnType = md.getReturnType();
                String returnTypeName = returnType.getSimpleName();

                //out.append(returnTypeName).append(" ");

                System.out.println(out + md.getName());
            }

            //System.out.println(md.getName());
        }
    }
}
