package com.freeman.patterns.adapter.shop2;

public class ProductAdaptor implements Pricable {

    private Costable product;
    private double price;

    public ProductAdaptor(Costable product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        price = product.getCost();
        return price;
    }

    @Override
    public String toString() {
        return product.toString();
    }
}
