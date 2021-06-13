package com.smart.context.annotation;

import com.smart.Car;
import com.smart.context.MyBeanFactoryPostProcessor;
import com.smart.context.MyBeanPostProcessor;
import com.smart.context.MyBeanPostProcessor2;
import com.smart.context.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 运行 {@link AnnotationApplicationContextTest} 控制台会打印出Bean的生命周期的过程
 */
@Configuration//这个注解的作用相当于beans.xml
public class Beans {

	/*
	 * 可以有多个Spring IOC容器级生命周期接口的实现类，例如BeanPostProcessor，加上@Order即可。
	 */
	@Bean
	public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	public InstantiationAwareBeanPostProcessor getInstantiationAwareBeanPostProcessor() {
		return new MyInstantiationAwareBeanPostProcessor();
	}

	@Order(1)
	@Bean
	public BeanPostProcessor getBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}


	@Order(2)
	@Bean
	public BeanPostProcessor getBeanPostProcessor2() {
		return new MyBeanPostProcessor2();
	}

	@Bean(name = "car")
	public Car buildCar() {
		Car car = new Car();
		car.setBrand("红旗CA72");
		car.setMaxSpeed(200);
		return car;
	}
}
