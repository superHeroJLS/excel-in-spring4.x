package com.smart.simple;

public class Car {
    private String brand;

    //Bean实例化的时候必须要有默认的构造函数
    public Car() {
        System.out.println("Car Constructor without args");
    }

    public Car(String brand) {
        this.brand = brand;
    }
}
