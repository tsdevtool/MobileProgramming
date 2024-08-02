package com.crissiiu.models;

import java.io.Serializable;

public class Products implements Serializable {
    int productCode;
    String productName;
    double productPrice;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Products(int productCode, double productPrice, String productName) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productName = productName;
    }
}
