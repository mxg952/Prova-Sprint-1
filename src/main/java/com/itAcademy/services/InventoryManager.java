package com.itAcademy.services;

import com.itAcademy.exceptions.DuplicateProductException;
import com.itAcademy.exceptions.ProductNotFoundException;
import com.itAcademy.models.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryManager {

    Set<Product> products = new HashSet<>();

    public InventoryManager(Set<Product> inventory) {
        this.products = new HashSet<>(inventory);
    }

    public void addProduct(Product product) throws DuplicateProductException {

        boolean duplicateExists = products.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(product.getName()));

        if (duplicateExists) {
            throw new DuplicateProductException("El producte està duplicat");
        }

        products.add(product);

    }

    public Product findByName(String productName) throws ProductNotFoundException {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("El producte no existeix."));
    }

    public Set<Product> getLowStockProducts(int llindar) {
        return products.stream()
                .filter(p -> p.getQuantity() < llindar)
                .collect(Collectors.toSet());
    }

    public int getStock() {
        return products.size();
    }

    public double getTotalInventoryValue() {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

}
