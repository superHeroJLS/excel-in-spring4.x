package com.smart.resourceloader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 这就是ResourceLoader实现的功能，开发人员不需要显示的使用特定的Resource，
 * 只需要提供资源的特殊标识(classpath:, classpath*:, file:, http://, ftp://)就能够使用合适的Resource加载资源。
 *
 * ResourceLoader接口仅有一个getResource(String location)方法，可以根据一个资源地址加载文件资源。
 * 不过，资源地址仅支持带资源类型前缀的表达式，不支持Ant风格的资源路径表达式。ResourcePatternResolver扩展ResourceLoader接口，
 * 定义了一个新的接口方法getResources(String locationPattern)，该方法支持带资源类型前缀及Ant风格的资源路径表达式。
 * PathMatchingResourcePatternResolver是Spring提供的标准实现类
 */
public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //加载所有类包、JAR包中com. smart (及子孙包)下以.xml为后缀的资源
        Resource[] resources = resolver.getResources("classpath*:/com/smart/**/*.xml");
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }


    }
}
