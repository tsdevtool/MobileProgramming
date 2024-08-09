package com.crissiiu.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    public Product(int id, double productPrice, String productName) {
        this.id = id;
        this.productPrice = productPrice;
        this.productName = productName;
    }

    public Product() {
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return id + ": " + productName + " - " + productPrice + " vnđ";
    }

    private int id;
    private String productName;
    private double productPrice;





}
