package com.example.supermarket_kdxfproject2.entity;


public class Cargo {
    private int id;
    private String classification;//分类
    private String Brand;//品牌
    private String name;
    private double price;
    private int number;



    public Cargo(int id, String classification, String Brand, String name, double price, int number) {
        this.id = id;
        this.classification = classification;
        this.Brand = Brand;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Cargo(String classification, String brand, String name, double price, int number) {
        this.classification = classification;
        Brand = brand;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Cargo() {
    }



    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * 设置
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * 获取
     * @return Brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * 设置
     * @param Brand
     */
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "Cargo{id = " + id + ", classification = " + classification + ", Brand = " + Brand + ", name = " + name + ", price = " + price + ", number = " + number + "}";
    }
}
