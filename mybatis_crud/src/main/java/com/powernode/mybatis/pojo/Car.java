package com.powernode.mybatis.pojo;

public class Car {
    private long car_num;
    private String brand;
    private Double guide_price;
    private String produce_time;
    private String car_type;

    public Car() {
    }

    public Car(long car_num, String brand, Double guide_price, String produce_time, String car_type) {
        this.car_num = car_num;
        this.brand = brand;
        this.guide_price = guide_price;
        this.produce_time = produce_time;
        this.car_type = car_type;
    }

    public long getCar_num() {
        return car_num;
    }

    public void setCar_num(long car_num) {
        this.car_num = car_num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getGuide_price() {
        return guide_price;
    }

    public void setGuide_price(Double guide_price) {
        this.guide_price = guide_price;
    }

    public String getProduce_time() {
        return produce_time;
    }

    public void setProduce_time(String produce_time) {
        this.produce_time = produce_time;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_tyoe) {
        this.car_type = car_tyoe;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_num=" + car_num +
                ", brand='" + brand + '\'' +
                ", guide_price=" + guide_price +
                ", produce_time='" + produce_time + '\'' +
                ", car_type='" + car_type + '\'' +
                '}';
    }
}
