package com.smart.service;

import com.smart.dao.TestDao;

public class TestService {
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void save() {
        stringThreadLocal.set("threadLocal");
        System.out.println("this is save method in TestService, current thread: " + Thread.currentThread().getName() + ", stringThreadLocal is: " + stringThreadLocal.get());
        new TestDao().save();
    }

}
