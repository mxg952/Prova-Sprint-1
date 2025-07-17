package com.itAcademy.models;

public class NonPerishableProduct extends Product implements Discount {

    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

   /* public double applyDiscount(double discount, String message) {

        System.out.println(message);

        double discountedPrice = getPrice() * (1 - discount / 100.0);

        /*Product p.setPrice();

        if(p instanceof NonPerishableProduct){
            String resposta = System.out.println(message);
        }

    }
        return discountedPrice;
    }*/


    @Override
    public double applyDiscount(double discount, String message) {
        System.out.println(message);
        return getPrice() - (getPrice() * discount / 100.0);
    }

}
