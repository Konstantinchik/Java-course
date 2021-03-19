package by.it.plehanova.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> bean = Bean.class;

        Object obj = bean.getDeclaredConstructor().newInstance();
        Method[] methods = bean.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                int modifier = method.getModifiers();
                String name = method.getName();
                Param p = method.getAnnotation(Param.class);

                if (Modifier.isStatic(modifier)) {
                    System.out.println(name + " " + method.invoke(null, p.a(),p.b()));
                } else {
                    System.out.println(name + " " + method.invoke(obj, p.a(),p.b()));
                }
            }
        }
    }
}
