package com.inventory.system.view;

import java.util.Scanner;
import com.inventory.system.model.Product;
import com.inventory.system.controller.ProductController;

/**
    * {@code InventorySystem} representa la vista principal del sistema de inventario.
    * <p>
        * Permite interactuar con el usuario a través de la consola, ofreciendo las opciones
        * para realizar operaciones CRUD sobre los productos.
    * </p>
    * 
    * @author 
    * @version 1.0
*/
public class InventorySystem {
    
    /**
        * Controlador de productos para gestionar la lógica de negocio.
    */
    private static final ProductController controller = new ProductController();
    
    /**
        * Scanner para la entrada de datos por consola.
    */
    private static final Scanner scanner = new Scanner(System.in);

    /**
        * Método principal que inicia el sistema de inventario.
        *
        * @param args argumentos de la línea de comandos (no utilizados)
    */
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n--- Sistema de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Ver productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("¡Opción inválida!");
            }
        } while (option != 5);
    }

    /**
        * Solicita los datos de un nuevo producto y lo agrega al inventario.
    */
    private static void addProduct() {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();
        System.out.print("Ingrese la cantidad disponible del producto: ");
        int quantity = scanner.nextInt();

        Product product = new Product(id, name, price, quantity);
        controller.addProduct(product);
        System.out.println("¡Producto agregado exitosamente!");
    }

    /**
        * Muestra todos los productos almacenados en el inventario.
    */
    private static void viewProducts() {
        System.out.println("\n--- Lista de Productos ---");
        for (Product product : controller.getAllProducts()) {
            System.out.println("ID: " + product.getId() +
                               ", Nombre: " + product.getName()
                    + ", Precio: $" + product.getPrice()
                    + ", Cantidad: " + product.getQuantity());
        }
    }

    /**
        * Actualiza la información de un producto existente.
    */
    private static void updateProduct() {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double price = scanner.nextDouble();
        System.out.print("Ingrese la nueva cantidad del producto: ");
        int quantity = scanner.nextInt();

        boolean updated = controller.updateProduct(id, name, price, quantity);
        if (updated) {
            System.out.println("¡Producto actualizado exitosamente!");
        } else {
            System.out.println("¡Producto no encontrado!");
        }
    }

    /**
        * Elimina un producto del inventario.
    */
    private static void deleteProduct() {
        System.out.print("Ingrese el ID del producto que desee eliminar:  ");
        int id = scanner.nextInt();
        boolean deleted = controller.deleteProduct(id);
        if (deleted) {
            System.out.println("El producto se ha eliminado con exito");
        } else {
            System.out.println("No existe un producto con esa ID");
        }
    }    
}
