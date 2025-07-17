package com.itAcademy.services;

import com.itAcademy.exceptions.NotFoundProductException;
import com.itAcademy.models.NonPerishableProduct;
import com.itAcademy.models.Product;

import java.util.ArrayList;
import java.util.List;

public class InventariManger {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean itExist(String productName) throws NotFoundProductException {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                return true;
            }
            throw new NotFoundProductException("El producte no existeix.");
        }
        return false;
    }

    public Product foundByName(String productName) throws NotFoundProductException {
        boolean exist = itExist(productName);
        Product productFound = null;

        if (exist) {
            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(productName)) {
                    return productFound;
                }
            }

        }
        return null;
    }

    public List<Product> getAllProducts(int llindar) {

        List<Product> newList = new ArrayList<>();

       for (Product p : products) {
          double quantity = p.getQuantity();
           if (quantity >  llindar) {
               newList.add(p);
           }
       }
       return newList;
    }

    public double sumAllProdcuts() {
        double suma = 0.0;
        for (Product p : products) {
            suma += p.getPrice() * p.getQuantity();
        }
        return suma;
    }





}
