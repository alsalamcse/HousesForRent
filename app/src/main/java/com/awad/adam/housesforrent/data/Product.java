package com.awad.adam.housesforrent.data;

import static com.awad.adam.housesforrent.R.string.Name;

/**
 * Created by user on 30/04/2018.
 */

public class Product {
    private String house;
    private double price;
    private double amount;
    private String email;
    private String fare;
    /**
     * if the product is bought.
     */
    private boolean isCompleted;
    /**
     * the path of product's image.
     */
    private String imgPath;
    /**
     * a special key or ID unique for each product (primary key)
     */
    private String keyId;
    private int Name;


    public Product() {
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getnName() {
        return Name;
    }
}

