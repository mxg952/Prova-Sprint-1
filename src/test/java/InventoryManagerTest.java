import com.itAcademy.exceptions.DuplicateProductException;
import com.itAcademy.exceptions.ProductNotFoundException;
import com.itAcademy.models.NonPerishableProduct;
import com.itAcademy.models.PerishableProduct;
import com.itAcademy.models.Product;
import com.itAcademy.services.InventoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    Set<Product> inventory;
    InventoryManager manager;

    @BeforeEach
    void init() {
        inventory =  new HashSet<Product>(Arrays.asList(
                new PerishableProduct("Apple Juice", 1.5, 12, LocalDate.now().plusMonths(1)),
                new PerishableProduct("Finger Snack", 1.8, 56, LocalDate.now().plusMonths(3)),
                new NonPerishableProduct("Yerba Mate", 4.5, 1),
                new PerishableProduct("Pepper Ice Cream", 5.8, 35, LocalDate.now().plusMonths(4)))
        );
        manager = new InventoryManager(inventory);
    }

    @Test
    void testFindByName() throws ProductNotFoundException {
        assertEquals("Apple Juice", manager.findByName("Apple Juice").getName());
    }

    @Test
    void testFindByNameIgnoreCase() throws ProductNotFoundException {
        assertEquals("Apple Juice", manager.findByName("APPLE JUICE").getName());
    }

    @Test
    void testFindByNameNotFound(){
        assertThrows(ProductNotFoundException.class, () -> manager.findByName("banana"));
    }

    @Test
    void testAddNewProduct() throws ProductNotFoundException, DuplicateProductException {
        Product patatita = new PerishableProduct("Patatita", 2.5, 9, LocalDate.now().plusYears(8));
        manager.addProduct(patatita);
        assertEquals("Patatita", manager.findByName("Patatita").getName());
        assertEquals(5, manager.getStock());
    }

    @Test
    void testAddExistsProduct(){
        Product finger = new PerishableProduct("Finger Snack", 1.8, 56, LocalDate.now().plusMonths(3));
        assertThrows(DuplicateProductException.class, () -> manager.addProduct(finger));
    }

    @Test
    void testGetLowStockProducts() {
        Set<Product> lowStock = manager.getLowStockProducts(5);
        assertEquals(1, lowStock.size());
    }

    @Test
    void testGetTotalInventoryValue(){
        assertEquals(326.3, manager.getTotalInventoryValue());
    }

}

