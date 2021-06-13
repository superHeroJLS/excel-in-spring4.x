package com.smart.context.annotation;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextTest {

	 public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		Car car =ctx.getBean("car",Car.class);
		car.introduce();

		car.destroy();

		//根据Class获取beanName
		ctx.getBeanNamesForType(Car.class);
	}
}
