package com.example.sk.javabootcamp.skjavabootcamp.controllers;

import com.example.sk.javabootcamp.skjavabootcamp.exceptions.ProductNotFoundException;
import com.example.sk.javabootcamp.skjavabootcamp.models.Product;
import com.example.sk.javabootcamp.skjavabootcamp.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    Product newCategory(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

    }

    @GetMapping("/products/name/{name}")
    Product getProductByName(@PathVariable String name){
        return productRepository.findProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException(name));
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCategory(newProduct.getCategory());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteCategory(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
