package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private String brand;
	private String color;
	private int maxSpeed;
	private String name;
	private BeanFactory beanFactory;
	private String beanName;

	public Car() {
		System.out.println("调用Car()构造函数。");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性: " + brand);
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public String toString() {
		return "brand:" + brand + "/color:" + color + "/maxSpeed:"+ maxSpeed;
	}

	public void setColor(String color) {
		System.out.println("调用setColor()设置属性: " + color);
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		System.out.println("调用setMaxSpeed()设置属性: " + maxSpeed);
		this.maxSpeed = maxSpeed;
	}
	
	public void introduce(){
		System.out.println("introduce:"+this.toString());
	}
	

	// BeanFactoryAware接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware.setBeanFactory()。");
		this.beanFactory = beanFactory;
	}

	// BeanNameAware接口方法
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName()。");
		this.beanName = beanName;
	}

	// InitializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet()。");
	}

	// DisposableBean接口方法
	public void destroy() throws Exception {
		System.out.println("调用DisposableBean.destory()。");
	}

	//在xml中手动指定的init-method，在afterPropertiesSet()方法之后被调用
	public void myInit() {		
		System.out.println("调用myInit()，将maxSpeed设置为240。");
		this.maxSpeed = 240;
	}

	//在xml中手动指定的destory-method
	public void myDestroy() {
		System.out.println("调用myDestroy()。");
	}

	/**
	 *  Spring中Bean指定init方法和destroy的几种方法：
	 *      1：在配置类中 @Bean(initMethod = "init",destroyMethod = "destory")注解指定
	 *      2：实现InitializingBean接口重写其afterPropertiesSet方法，实现DisposableBean接口重写destroy方法
	 *      3：利用java的JSR250规范中的@PostConstruct标注在init方法上，@PreDestroy标注在destroy注解上
	 */
	//使用Annotation的方式指定init-method，在afterPropertiesSet()方法之前被调用
	@PostConstruct
	public void annotationInit() {
		System.out.println("调用annotationInit()，将maxSpeed设置为240。");
		this.maxSpeed = 240;
	}

	@PreDestroy
	public void destory() {
		System.out.println("调用destory()");
	}
}
