package com.smart.inheritedtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestInheritedOfAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        TestInheritedOfAnnotation tia = new TestInheritedOfAnnotation();
        Method method = tia.getClass().getMethod("test");
        Annotation[] as = method.getAnnotations();
        if (method.isAnnotationPresent(InheritedChild.class)) {
            InheritedChild ic = method.getAnnotation(InheritedChild.class);
            System.out.println("is value:" + ic.value());
            Arrays.stream(ic.getClass().getAnnotations()).forEach(it -> System.out.println(it.annotationType()));
//            System.out.print("ic is InheritedParent Annotation Present: " + ic.getClass().isAnnotationPresent(InheritedParent.class));
        };

    }


    @InheritedChild("child")
    public void test() {
        System.out.println("this is test method");
    }
}
