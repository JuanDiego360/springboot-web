package com.juan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.juan.springboot.di.app.springboot_di.models.Product;
import com.juan.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository(); // aquí se crea la conexión con el repositorio (base
                                                                    // de datos o fuente de datos)

    public List<Product> findAll() {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findAll().stream().map(p -> {
            Double pricDouble = p.getPrice() * 1.25d;
            p.setPrice(pricDouble.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findById(id);
    }
}
