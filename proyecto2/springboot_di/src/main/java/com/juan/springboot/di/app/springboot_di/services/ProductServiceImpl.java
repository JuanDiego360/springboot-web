package com.juan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juan.springboot.di.app.springboot_di.models.Product;
import com.juan.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;
import com.juan.springboot.di.app.springboot_di.repositories.ProductServices;

@Component
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepositoryImpl repository; // aquí se crea la conexión con el
                                              // repositorio (base
    // de datos o fuente de datos)

    @Override
    public List<Product> findAll() {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findAll().stream().map(p -> {
            Double pricDouble = p.getPrice() * 1.25d;
            // p.setPrice(pricDouble.longValue()); aplicamos el principio de inmutabilidad
            // no modificamos el objeto original, creamos uno nuevo
            return new Product(p.getId(), p.getName(), pricDouble.longValue());
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findById(id);
    }
}
