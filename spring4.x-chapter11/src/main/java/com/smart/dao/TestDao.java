package com.smart.dao;

public class TestDao {
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void save() {
        String val = stringThreadLocal.get();
        System.out.println("this is save method in TestDao, current thread: " + Thread.currentThread().getName() + ", stringThreadLocal is: " + val);
    }
}
