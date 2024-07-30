package com.example.models;

public class Beers {
    public Beers(int beerCode, String beerName, double beerPrice, int beerThumb) {
        this.beerCode = beerCode;
        this.beerName = beerName;
        this.beerPrice = beerPrice;
        this.beerThumb = beerThumb;
    }

    public int getBeerCode() {
        return beerCode;
    }

    public void setBeerCode(int beerCode) {
        this.beerCode = beerCode;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getBeerPrice() {
        return beerPrice;
    }

    public void setBeerPrice(double beerPrice) {
        this.beerPrice = beerPrice;
    }

    public int getBeerThumb() {
        return beerThumb;
    }

    public void setBeerThumb(int beerThumb) {
        this.beerThumb = beerThumb;
    }

    int beerCode;
    String beerName;
    double beerPrice;
    int beerThumb;
}
