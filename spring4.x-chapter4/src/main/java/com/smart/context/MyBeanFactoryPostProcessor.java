package com.smart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		BeanDefinition bd = bf.getBeanDefinition("car");
		//Bean初始化完成之后，对bean中的property值进行调整
		bd.getPropertyValues().addPropertyValue("brand", "兰博基尼");
		System.out.println("-----调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
	}
}
