package com.smart.aspectj.example;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


public class AspectConfigTest {

	@Test
	public void config(){
		String configPath = "com/smart/aspectj/example/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		waiter.serveTo("John");
		waiter.toString();
	}
}
