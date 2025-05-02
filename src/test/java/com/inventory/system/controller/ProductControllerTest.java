package com.inventory.system.controller;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import com.inventory.system.model.Product;

/**
    * Pruebas unitarias para la clase {@link ProductController}.
*/
public class ProductControllerTest {
    
    private ProductController controller;
    
    /**
        * Configuración inicial antes de cada prueba.
    */
    @Before
    public void setUp() {
        controller = new ProductController();
    }
    
    /**
        * Prueba que se pueda agregar un producto correctamente.
    */
    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Laptop", 1000.0, 5);
        controller.addProduct(product);
        assertEquals(1, controller.getAllProducts().size());
    }
    
    /**
        * Prueba que se pueda encontrar un producto por su ID.
    */
    @Test
    public void testFindProductById() {
        Product product = new Product(2, "Mouse", 25.0, 50);
        controller.addProduct(product);
        Product found = controller.findProductById(2);
        assertNotNull(found);
        assertEquals("Mouse", found.getName());
    }
    
    /**
        * Prueba que se pueda actualizar un producto correctamente.
    */
    @Test
    public void testUpdateProduct() {
        Product product = new Product(3, "Keyboard", 45.0, 30);
        controller.addProduct(product);
        boolean updated = controller.updateProduct(3, "Mechanical Keyboard", 60.0, 20);
        assertTrue(updated);

        Product updatedProduct = controller.findProductById(3);
        assertEquals("Mechanical Keyboard", updatedProduct.getName());
        assertEquals(60.0, updatedProduct.getPrice(), 0.001);
        assertEquals(20, updatedProduct.getQuantity());
    }
    
    /**
        * Prueba que se pueda eliminar un producto correctamente.
    */
    @Test
    public void testDeleteProduct() {
        Product product = new Product(4, "Monitor", 250.0, 10);
        controller.addProduct(product);
        boolean deleted = controller.deleteProduct(4);
        assertTrue(deleted);
        assertNull(controller.findProductById(4));
    }
    
    /**
     * Prueba que no se actualice ni elimine un producto que no existe.
     */
    @Test
    public void testUpdateAndDeleteNonExistingProduct() {
        boolean updated = controller.updateProduct(99, "Tablet", 300.0, 15);
        assertFalse(updated);

        boolean deleted = controller.deleteProduct(99);
        assertFalse(deleted);
    }
}
