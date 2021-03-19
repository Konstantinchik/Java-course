package by.it.kglushchenko.jd01_10;

import java.lang.annotation.*;


@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Param {
    int a();
    int b();
}
