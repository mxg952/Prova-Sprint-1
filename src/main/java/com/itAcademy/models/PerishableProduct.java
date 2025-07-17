package com.itAcademy.models;

import java.time.LocalDate;
import java.util.Date;

public class PerishableProduct extends Product implements Discount {

    private LocalDate expirationDate;


    public PerishableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired(){
        LocalDate now = LocalDate.now();
        if (expirationDate.isAfter(now) || expirationDate.isEqual(now) ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double applyDiscount(double discount, String message) {
        System.out.println(message);

        double extraDiscount = getPrice() * 0.02;
        return getPrice() - discount - extraDiscount;
    }

}
