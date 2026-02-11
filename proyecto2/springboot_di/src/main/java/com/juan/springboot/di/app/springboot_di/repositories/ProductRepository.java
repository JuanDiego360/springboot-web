package com.juan.springboot.di.app.springboot_di.repositories;

import java.util.List;
import java.util.Arrays;

import com.juan.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    // Constructor
    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Laptop", 1000L),
                new Product(2L, "Mouse", 20L),
                new Product(3L, "Keyboard", 50L),
                new Product(4L, "Monitor", 200L),
                new Product(5L, "Webcam", 50L),
                new Product(6L, "Headphones", 100L),
                new Product(7L, "Microphone", 50L),
                new Product(8L, "Speakers", 100L),
                new Product(9L, "Printer", 200L),
                new Product(10L, "Scanner", 100L));
    }

    // Metodo para obtener todos los productos
    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
