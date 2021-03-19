package by.it.leshchenko.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getConstructor();
        Bean bean = constructor.newInstance();

        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                int modifiers = method.getModifiers();
                if (Modifier.isStatic(modifiers)) {
                    System.out.printf("%s %s\n", method.getName(), method.invoke(null, a, b));
                } else {
                    System.out.printf("%s %s\n", method.getName(), method.invoke(bean, a, b));
                }
            }
        }
    }
}