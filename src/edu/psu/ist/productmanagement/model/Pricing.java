package edu.psu.ist.productmanagement.model;

public class Pricing {
    private double price;

    public Pricing(double price) {
        this.price = price;
    }

    //assuming percentage discount
    public double applyDiscount(double discount) {
        return price - (price * discount / 100);
    }

    public double getPrice() {
        return price;
    }
}
