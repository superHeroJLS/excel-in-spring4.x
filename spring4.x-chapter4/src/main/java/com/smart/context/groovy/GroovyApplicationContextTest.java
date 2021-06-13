package com.smart.context.groovy;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyApplicationContextTest {
    public static void main(String[] args) {
        getBean();
    }

    public static void getBean() {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:com/smart/context/groovy-beans.groovy");
        Car car = ctx.getBean("car", Car.class);
        car.introduce();
    }
}
