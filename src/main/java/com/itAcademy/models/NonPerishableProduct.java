package com.itAcademy.models;

public class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double applyDiscount(double discount, String message) {

        /*Product p.setPrice();

        if(p instanceof NonPerishableProduct){
            String resposta = System.out.println(message);
        }

    }*/
        return discount;
    }
}
