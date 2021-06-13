package com.smart.classloader;

import java.io.IOException;

public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current thread loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        System.out.println("parent parent loader: " + loader.getParent().getParent());// root ClassLoader是使用c++写的在java中访问不到
    }
}
