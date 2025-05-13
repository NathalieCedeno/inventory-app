package com.inventory.system.model;

/**
    * {@code Product} representa un producto dentro del sistema de inventario.
    * <p>
        * Cada producto posee un identificador único, nombre, precio y cantidad.
    * </p>
*/
public class Product {
    
    /**
        * Identificador único del producto.
    */
    private int id;
    
    /**
        * Nombre del producto.
    */
    private String name;
    
    /**
        * Precio unitario del producto.
    */
    private double price;
    
    /**
        * Cantidad disponible en inventario.
    */
    private int quantity;

    /**
        * Constructor para inicializar un producto con todos sus atributos.
        *
        * @param id el identificador único del producto
        * @param name el nombre del producto
        * @param price el precio unitario del producto
        * @param quantity la cantidad disponible del producto
    */
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    /**
        * Obtiene el identificador único del producto.
        *
        * @return el ID del producto
    */
    public int getId() { return id; }
    
    /**
        * Establece el identificador único del producto.
        *
        * @param id el nuevo ID del producto
    */
    public void setId(int id) { this.id = id; }

    /**
        * Obtiene el nombre del producto.
        *
        * @return el nombre del producto
    */
    public String getName() { return name; }
    
    /**
        * Establece el nombre del producto.
        *
        * @param name el nuevo nombre del producto
    */
    public void setName(String name) { this.name = name; }

    /**
        * Obtiene el precio del producto.
        *
        * @return el precio del producto
    */
    public double getPrice() { return price; }
    
    /**
        * Establece el precio del producto.
        *
        * @param price el nuevo precio del producto
    */
    public void setPrice(double price) { this.price = price; }

    /**
        * Obtiene la cantidad disponible del producto.
        *
        * @return la cantidad disponible
    */
    public int getQuantity() { return quantity; }
    
    /**
        * Establece la cantidad disponible del producto.
        *
        * @param quantity la nueva cantidad disponible.
    */
    public void setQuantity(int quantity) { this.quantity = quantity; }

}
