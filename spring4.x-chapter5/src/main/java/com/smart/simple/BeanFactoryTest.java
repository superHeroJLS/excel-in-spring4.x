package com.smart.simple;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {
    public static void main(String[] args) throws IOException {
        //创建ResourcePatternResolver(加载resource，这里用于加载beans.xml)
        ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
        Resource res = rpr.getResource("classpath:/com/smart/simple/beans.xml");
        System.out.println(res.getURL());

        //创建DefaultListableBeanFactory、XmlBeanDefinitionReader(从beans.xml中读取BeanDefinition)
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        Car car = factory.getBean("car", Car.class);
    }
}
