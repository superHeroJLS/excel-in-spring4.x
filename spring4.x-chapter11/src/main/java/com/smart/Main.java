package com.smart;

import com.smart.service.TestService;

public class Main {
    public static void main(String[] args) {
        TestService ts = new TestService();
        ts.save();
    }
}
