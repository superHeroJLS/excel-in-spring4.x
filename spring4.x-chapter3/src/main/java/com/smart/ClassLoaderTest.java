package com.smart;

public class ClassLoaderTest {
    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current thread loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        System.out.println("parent parent loader: " + loader.getParent().getParent());// root ClassLoader是使用c++写的在java中访问不到
    }
}
