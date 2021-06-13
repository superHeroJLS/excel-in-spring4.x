package com.smart.defaultinjectiontype;

public class Car {
	public String brand;
	private String corp;
	private double price;
	private int maxSpeed;

	public Car() {
		System.out.println("Car Constructor Default");
	}
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
		System.out.println("Car Constructor with two args");
	}	

	public Car(String brand, String corp, double price) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	public Car(String brand, String corp, int maxSpeed) {
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("setBrand()");
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
	}

}

