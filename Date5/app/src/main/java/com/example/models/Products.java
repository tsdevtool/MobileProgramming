package com.example.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Products implements Serializable {
    public Products(double productPrice, String productName) {
        this.productPrice = productPrice;
        this.productName = productName;
    }

    private String productName;
    private double productPrice;

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

    @NonNull
    @Override
    public String toString() {
        return this.getProductName() + "-" + this.getProductPrice();
    }
}
