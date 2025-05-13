package com.inventory.system.controller;

import java.util.List;
import java.util.ArrayList;
import com.inventory.system.model.Product;

/**
    * {@code ProductController} administra las operaciones CRUD para objetos {@link Product}.
    * <p>
        * Esta clase actúa como capa de control en el patrón MVC, gestionando una lista de productos.
        * Permite agregar, consultar, actualizar y eliminar productos.
    * </p>
*/
public class ProductController {
    
    /**
        * Lista de productos gestionados por el controlador.
    */
    private final List<Product> products = new ArrayList<>();

    /**
        * Agrega un nuevo producto a la lista de productos.
        *
        * @param product el producto que se desea agregar
    */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
        * Actualiza los atributos de un producto existente en la lista.
        *
        * @param id el identificador del producto a actualizar
        * @param name el nuevo nombre del producto
        * @param price el nuevo precio del producto
        * @param quantity la nueva cantidad disponible del producto
        * @return {@code true} si el producto fue encontrado y actualizado; {@code false} en caso contrario
    */
    public boolean updateProduct(int id, String name, double price, int quantity) {
        Product product = findProductById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            return true;
        }
        return false;
    }
    
    /**
        * Elimina un producto de la lista basado en su ID.
        *
        * @param id el identificador del producto a eliminar
        * @return {@code true} si el producto fue encontrado y eliminado; {@code false} en caso contrario
    */
    public boolean deleteProduct(int id) {
        Product product = findProductById(id);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }
            
    /**
        * Retorna todos los productos almacenados.
        *
        * @return una lista de productos
    */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
        * Busca un producto por su identificador único (ID).
        *
        * @param id el identificador del producto a buscar
        * @return el producto encontrado, o {@code null} si no existe
    */
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
