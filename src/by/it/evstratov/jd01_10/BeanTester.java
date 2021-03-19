package by.it.evstratov.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<Bean> bean = Bean.class;
        Constructor<Bean> constructor = bean.getConstructor();
        Object o = constructor.newInstance();

        Method[] methods = bean.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)){
                Param param = method.getAnnotation(Param.class);
                int a = param.a();
                int b = param.b();
                int modifiers = method.getModifiers();
                if(Modifier.isStatic(modifiers)){
                    System.out.println(method.getName()+" - "+method.invoke(null,a,b));
                }else{
                    System.out.println(method.getName()+" - "+method.invoke(o,a,b));
                }
            }
        }

    }

}
